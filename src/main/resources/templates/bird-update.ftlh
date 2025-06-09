<!DOCTYPE html>
<html>

<head>
    <title>Edit Bird</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
    <div class="container mt-4">
        <h1>Edit Bird</h1>

        <form action="/birds/update" method="post" enctype="multipart/form-data">
            <input type="hidden" name="birdId" value="${bird.birdId}">


            <div class="mb-3">

                <div class="mb-2">
                    <img src="${bird.imagePath}" alt="Current image" style="max-width: 200px;">
                    <div class="form-text">Current image</div>
                </div>

                <label for="image" class="form-label">New Image (leave blank to keep current)</label>
                <input type="file" class="form-control" id="image" name="image" accept="image/*">
            </div>

            <div class="mb-3">
                <label for="name" class="form-label">Name</label>
                <input type="text" class="form-control" id="name" name="name" value="${bird.name}" required>
            </div>

            <div class="mb-3">
                <label for="description" class="form-label">Description</label>
                <textarea class="form-control" id="description" name="description"
                    required>${bird.description}</textarea>
            </div>

            <div class="mb-3">
                <label for="habitat" class="form-label">Habitat</label>
                <input type="text" class="form-control" id="habitat" name="habitat" value="${bird.habitat!''}">
            </div>

            <div class="mb-3">
                <label for="lifeSpan" class="form-label">Life Span</label>
                <input type="number" class="form-control" id="lifeSpan" name="lifeSpan" value="${bird.lifeSpan}">
            </div>

            <button type="submit" class="btn btn-primary">Update</button>
            <a href="/birds/${bird.birdId}" class="btn btn-secondary">Cancel</a>
        </form>
    </div>
</body>

</html>