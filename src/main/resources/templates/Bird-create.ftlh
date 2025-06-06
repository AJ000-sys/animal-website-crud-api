<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add New Bird</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-4">
        <h1 class="mb-4">Add New Bird</h1>
        
        <form action="/birds/new" method="post" class="border p-4 rounded">
            <div class="mb-3">
                <label class="form-label">Name*</label>
                <input type="text" class="form-control" name="name" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Breed</label>
                <input type="text" class="form-control" name="breed">
            </div>
            <div class="mb-3">
                <label class="form-label">Age</label>
                <input type="number" class="form-control" name="age">
            </div>
            <div class="mb-3">
                <label class="form-label">Description*</label>
                <textarea class="form-control" name="description" required></textarea>
            </div>
            <button type="submit" class="btn btn-primary">Save Bird</button>
            <a href="/birds" class="btn btn-secondary">Cancel</a>
        </form>
    </div>
</body>
</html>