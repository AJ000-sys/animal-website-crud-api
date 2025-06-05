<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Bird List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .action-buttons {
            white-space: nowrap;
        }
    </style>
</head>
<body>
    <div class="container mt-4">
        <h1 class="mb-4">Bird List</h1>
        
        <div class="row mb-3">
            <div class="col-md-6">
                <a href="/birds/new" class="btn btn-primary">Add New Bird</a>
            </div>
            <div class="col-md-6">
                <form action="/birds/search" method="get" class="d-flex">
                    <input type="text" name="name" class="form-control me-2" placeholder="Search by name">
                    <button type="submit" class="btn btn-outline-success">Search</button>
                </form>
            </div>
        </div>

        <#if birds?has_content>
            <table class="table table-striped table-hover">
                <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Breed</th>
                        <th>Age</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <#list birds as bird>
                    <tr>
                        <td>${bird.birdId}</td>
                        <td>${bird.name}</td>
                        <td>${bird.breed!''}</td>
                        <td>${bird.age}</td>
                        <td class="action-buttons">
                            <a href="/birds/${bird.birdId}" class="btn btn-info btn-sm">View</a>
                            <a href="/birds/edit/${bird.birdId}" class="btn btn-warning btn-sm">Edit</a>
                            <a href="/birds/delete/${bird.birdId}" class="btn btn-danger btn-sm" 
                               onclick="return confirm('Are you sure you want to delete this bird?')">Delete</a>
                        </td>
                    </tr>
                    </#list>
                </tbody>
            </table>
        <#else>
            <div class="alert alert-warning">No birds found</div>
        </#if>
    </div>
</body>
</html>