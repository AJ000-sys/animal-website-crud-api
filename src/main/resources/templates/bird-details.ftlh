<!DOCTYPE html>
<html>

<head>
    <title>${Title}</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
    <div class="container mt-4">
        <h1>${Title}</h1>
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">${bird.name}</h5>
                <h6 class="card-subtitle mb-2 text-muted">${bird.breed!''}, Age: ${bird.age}</h6>
                <p class="card-text">${bird.description}</p>
                <a href="/birds/edit/${bird.birdId}" class="btn btn-warning">Edit</a>
                <a href="/birds" class="btn btn-secondary">Back to List</a>
            </div>
        </div>
    </div>
</body>

</html>