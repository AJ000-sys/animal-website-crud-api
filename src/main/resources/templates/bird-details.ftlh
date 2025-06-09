<!DOCTYPE html>
<html>

<head>
    <title>Bird Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .bird-image-container {
            height: 300px;
            background-color: #f4f4f4;
            display: flex;
            align-items: center;
            justify-content: center;
            overflow: hidden;
        }

        .bird-image {
            max-height: 100%;
            width: auto;
            object-fit: contain;
        }
    </style>
</head>

<body>
    <div class="container mt-4">
        <h1>Bird Details</h1>
        <div class="card">
            <div class="row g-0">
                <div class="col-md-4 bird-image-container">
                    <#if bird.imagePath?? && bird.imagePath !="">
                        <img src="${bird.imagePath}" class="bird-image rounded-start" alt="Image of ${bird.name}">
                        <#else>
                            <span class="text-muted">No image available</span>
                    </#if>
                </div>
                <div class="col-md-8">
                    <div class="card-body">
                        <h5 class="card-title">${bird.name}</h5>
                        <h6 class="card-subtitle mb-2 text-muted">
                            Habitat: ${bird.habitat!''} |
                            Life Span: ${bird.lifeSpan} years
                        </h6>
                        <p class="card-text">${bird.description}</p>
                        <div class="mt-4">
                            <a href="/birds/edit/${bird.birdId}" class="btn btn-warning">Edit</a>
                            <a href="/birds" class="btn btn-secondary">Back to List</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>

</html>