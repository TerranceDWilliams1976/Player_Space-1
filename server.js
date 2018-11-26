// const express = require('express');
// const compression = require('compression');

// const CONTEXT = '/angular-ngrx-material-starter';
// const PORT = 4000;

// const app = express();

// app.use(compression());
// app.use(CONTEXT, express.static(__dirname + '/dist'));
// app.use('/', express.static(__dirname + '/dist'));
// app.listen(PORT, () => console.log(`App running on localhost:${PORT}/${CONTEXT}`));

//Install express server
const express = require('express');
const path = require('path');

const app = express();

// Serve only the static files form the dist directory
app.use(express.static(__dirname + '/dist/<name-of-app>'));

app.get('/*', function(req,res) {
    
res.sendFile(path.join(__dirname+'/dist/<name-of-app>/index.html'));
});

// Start the app by listening on the default Heroku port
app.listen(process.env.PORT || 8080);