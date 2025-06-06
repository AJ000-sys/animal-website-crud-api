<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit ${bird.name}</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-4">
        <h1 class="mb-4">Edit ${bird.name}</h1>
        
        <form action="/birds/update" method="post" class="border p-4 rounded">
            <input type="hidden" name="birdId" value="${bird.birdId}">
            
            <div class="mb-3">
                <label class="form-label">Name*</label>
                <input type="text" class="form-control" name="name" value="${bird.name}" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Breed</label>
                <input type="text" class="form-control" name="breed" value="${bird.breed!''}">
            </div>
            <div class="mb-3">
                <label class="form-label">Age</label>
                <input type="number" class="form-control" name="age" value="${bird.age}">
            </div>
            <div class="mb-3">
                <label class="form-label">Description*</label>
                <textarea class="form-control" name="description" required>${bird.description}</textarea>
            </div>
            <button type="submit" class="btn btn-primary">Update Bird</button>
            <a href="/birds/${bird.birdId}" class="btn btn-secondary">Cancel</a>
        </form>
    </div>
</body>
</html>