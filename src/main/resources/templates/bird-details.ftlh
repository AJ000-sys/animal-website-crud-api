<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${bird.name} Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
    <div class="container mt-4">
        <div class="d-flex justify-content-between mb-4">
            <h1>${bird.name}</h1>
            <a href="/birds" class="btn btn-outline-secondary">Back to List</a>
        </div>

        <div class="card">
            <div class="card-body">
                <div class="row">
                    <div class="col-md-6">
                        <h5>Basic Information</h5>
                        <p><strong>Breed:</strong> ${bird.breed}</p>
                        <p><strong>Age:</strong> ${bird.age}</p>
                    </div>
                    <div class="col-md-6">
                        <h5>Description</h5>
                        <p>${bird.description}</p>
                    </div>
                </div>
                <div class="mt-4">
                    <a href="/birds/edit/${bird.birdId}" class="btn btn-primary">Edit</a>
                    <a href="/birds/delete/${bird.birdId}" class="btn btn-danger">Delete</a>
                </div>
            </div>
        </div>
    </div>
</body>

</html>