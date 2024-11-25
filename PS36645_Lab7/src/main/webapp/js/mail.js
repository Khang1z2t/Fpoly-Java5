function toggleField(fieldId, buttonId) {
    var field = document.getElementById(fieldId);
    var button = document.getElementById(buttonId);
    if (field.style.display === "none") {
        field.style.display = "block";
        button.style.display = "none";
    } else {
        field.style.display = "none";
        button.style.display = "block";
    }
}

tinymce.init({
    selector: '#mailContent',
});

document.addEventListener('focusin', (e) => {
    if (e.target.closest(".tox-tinymce, .tox-tinymce-aux, .moxman-window, .tam-assetmanager-root") !== null) {
        e.stopImmediatePropagation();
    }
});


document.addEventListener('DOMContentLoaded', function () {
    let selectedFiles = []

    document.getElementById('mailFile').addEventListener('change', function (event) {
        const previewContainer = document.getElementById('filePreview');
        const files = event.target.files;

        Array.from(files).forEach((file) => {
            if (file && file.type.startsWith('image/')) {
                selectedFiles.push(file);
                const reader = new FileReader();

                reader.onload = function (e) {
                    const previewImage = document.createElement('div');
                    previewImage.classList.add('preview-image');

                    previewImage.innerHTML = `
                        <button class="set-cover-image btn btn-outline-danger btn-sm">Chọn ảnh bìa</button>
                        <img src="${e.target.result}" alt="Image">
                        <button class="remove-image"><i class="fa-solid fa-xmark"></i></button>
                    `;

                    previewContainer.appendChild(previewImage);

                    // Handle remove image event
                    previewImage.querySelector('.remove-image').addEventListener('click', function (event) {
                        event.preventDefault();
                        const index = Array.from(previewContainer.children).indexOf(previewImage);
                        removeImage(index);
                    });

                    previewImage.querySelector('.set-cover-image').addEventListener('click', function (event) {
                        event.preventDefault();
                        const index = Array.from(previewContainer.children).indexOf(previewImage);
                        setCoverImage(index);
                    });
                };

                reader.readAsDataURL(file);
            }
        });
    });

    function removeImage(index) {
        selectedFiles.splice(index, 1);
        const previewContainer = document.getElementById('filePreview');
        const images = Array.from(previewContainer.getElementsByClassName('preview-image'));

        if (images[index]) {
            images[index].remove();  // Remove selected image
        }

        // Update indices of remaining images
        Array.from(previewContainer.children).forEach((child, idx) => {
            child.querySelector('.remove-image').setAttribute('data-index', idx);
        });
    }


    function setCoverImage(index) {
        if (index > 0) {
            const [file] = selectedFiles.splice(index, 1);
            selectedFiles.unshift(file);

            const previewContainer = document.getElementById('filePreview');
            const images = Array.from(previewContainer.getElementsByClassName('preview-image'));

            if (images[index]) {
                const coverImage = images[index];
                previewContainer.removeChild(coverImage);
                previewContainer.insertBefore(coverImage, previewContainer.firstChild);
            }

            // Update indices of remaining images
            Array.from(previewContainer.children).forEach((child, idx) => {
                child.querySelector('.remove-image').setAttribute('data-index', idx);
            });
        }
    }

    document.querySelector('form').addEventListener('submit', function (event) {
        event.preventDefault(); // Prevent default form submission

        const formData = new FormData(this);
        // formData.delete('mailFile');
        selectedFiles.forEach((file, index) => {
            formData.append('mailFile', file);
        });
    });
});