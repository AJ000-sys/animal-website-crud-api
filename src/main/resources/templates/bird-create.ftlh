<!DOCTYPE html>
<html>

<head>
    <title>Create New Bird</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
    <div class="container mt-4">
        <h1>Add new bird</h1>
        <form action="/birds/new" method="post">
            <div class="mb-3">
                <label for="name" class="form-label">Name</label>
                <input type="text" class="form-control" id="name" name="name" required>
            </div>

            <div class="mb-3">
                <label for="description" class="form-label">Description</label>
                <textarea class="form-control" id="description" name="description" required></textarea>
            </div>
            
            <div class="mb-3">
                <label for="lifeSpan" class="form-label">Life Span</label>
                <input type="number" class="form-control" id="lifeSpan" name="lifeSpan" required>
            </div>

            <div class="mb-3">
                <label for="habitat" class="form-label">Habitat</label>
                <input type="text" class="form-control" id="habitat" name="habitat" required>
            </div>

            <button type="submit" class="btn btn-primary">Submit</button>
            <a href="/birds" class="btn btn-secondary">Cancel</a>
        </form>
    </div>
</body>

</html>