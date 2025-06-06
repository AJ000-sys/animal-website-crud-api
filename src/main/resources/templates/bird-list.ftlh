<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bird Collection</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
    <div class="container mt-4">
        <h1 class="mb-4">Bird Collection</h1>
        <a href="/birds/new" class="btn btn-primary mb-4">Add New Bird</a>

        <div class="row">
            <#list birdslist as bird>
                <div class="col-md-4 mb-4">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">${bird.name}</h5>
                            <h6 class="card-subtitle mb-2 text-muted">${bird.breed}</h6>
                            <p class="card-text">Age: ${bird.age}</p>
                            <p class="card-text text-truncate">${bird.description}</p>
                            <div class="d-flex justify-content-between">
                                <a href="/birds/${bird.birdId}" class="btn btn-sm btn-outline-primary">Details</a>
                                <a href="/birds/edit/${bird.birdId}" class="btn btn-sm btn-outline-secondary">Edit</a>
                                <a href="/birds/delete/${bird.birdId}" class="btn btn-sm btn-outline-danger">Delete</a>
                            </div>
                        </div>
                    </div>
                </div>
            </#list>
        </div>
    </div>
</body>

</html>