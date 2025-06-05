<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Bird Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-4">
        <h1 class="mb-4">${bird.name}</h1>
        
        <div class="card">
            <div class="card-header">
                <h4>Bird Information</h4>
            </div>
            <div class="card-body">
                <dl class="row">
                    <dt class="col-sm-3">ID</dt>
                    <dd class="col-sm-9">${bird.birdId}</dd>
                    
                    <dt class="col-sm-3">Name</dt>
                    <dd class="col-sm-9">${bird.name}</dd>
                    
                    <dt class="col-sm-3">Description</dt>
                    <dd class="col-sm-9">${bird.description!''}</dd>
                    
                    <dt class="col-sm-3">Breed</dt>
                    <dd class="col-sm-9">${bird.breed!''}</dd>
                    
                    <dt class="col-sm-3">Age</dt>
                    <dd class="col-sm-9">${bird.age}</dd>
                </dl>
                
                <div class="mt-4">
                    <a href="/birds/edit/${bird.birdId}" class="btn btn-warning">Edit</a>
                    <a href="/birds" class="btn btn-secondary">Back to List</a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>