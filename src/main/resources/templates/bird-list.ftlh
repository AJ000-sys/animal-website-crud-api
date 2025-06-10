<!DOCTYPE html>
<html>

<head>
    <title>Bird List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
    <div class="container mt-4">
        <h1>Bird List</h1>
        <a href="/birds/new" class="btn btn-primary mb-3">Add New Bird</a>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Habitat</th>
                    <th>Life Span</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <#list birdslist as bird>
                    <tr>
                        <td>${bird.birdId}</td>
                        <td>${bird.name}</td>
                        <td>${(bird.description!"")?substring(0, [50, bird.description?length]?min)}<#if
                                (bird.description!"")?length gt 50>...</#if>
                        </td>
                        <td>${bird.habitat!''}</td>
                        <td>${bird.lifeSpan} years</td>
                        <td>
                            <a href="/birds/${bird.birdId}" class="btn btn-info btn-sm">View</a>
                            <a href="/birds/edit/${bird.birdId}" class="btn btn-warning btn-sm">Edit</a>
                            <a href="/birds/delete/${bird.birdId}" class="btn btn-danger btn-sm">Delete</a>
                        </td>
                    </tr>
                </#list>
            </tbody>
        </table>
    </div>
</body>

</html>