<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Reservation - Home</title>
    <style>

    body{
        background-image: url('https://wallpaper.forfun.com/fetch/13/13802eec9471e04b7d57dc14a18b6bc0.jpeg');
        background-size: cover;
        background-repeat: no-repeat;
        background-position: center;
    }
    .welcome-message {
        text-align: center;
        margin: 50px 0;
    }
    .action-buttons {
        display: flex;
        justify-content: center;
        margin: 30px 0;
    }
    .action-button {
        background-color: #4CAF50;
        border: none;
        color: white;
        padding: 15px 32px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;
        margin: 4px 2px;
        cursor: pointer;
        border-radius: 5px;
    }
    </style>
</head>
<body>
<div class="welcome-message">
    <h1>Welcome to My parking Application</h1>
    <p>A simple Parking management application with Grails and Groovy</p>
</div>

<div class="action-buttons">
    <a href="${createLink(controller:'PlaceDeParking', action:'index')}" class="action-button">Place</a>
    <a href="${createLink(controller:'Reservation', action:'index')}" class="action-button">Reservation</a>
    <a href="${createLink(controller:'Voiture', action:'index')}" class="action-button">Voiture</a>
</div>
</body>
</html>