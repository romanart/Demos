'use strict';

var webpack = require('webpack');

var config = {
    "mode": "production",
    "context": "/Users/romart/IdeaProjects/KUG/incrementalCompilation/build/kotlin-js-min/main",
    "entry": {
        "main": "./incrementalCompilation"
    },
    "output": {
        "path": "/Users/romart/IdeaProjects/KUG/incrementalCompilation/build/bundle",
        "filename": "[name].bundle.js",
        "chunkFilename": "[id].bundle.js",
        "publicPath": "/"
    },
    "module": {
        "rules": [
            
        ]
    },
    "resolve": {
        "modules": [
            "kotlin-js-min/main",
            "resources/main",
            "/Users/romart/IdeaProjects/KUG/incrementalCompilation/build/node_modules",
            "node_modules"
        ]
    },
    "plugins": [
        
    ]
};
var defined = {
    "PRODUCTION": true,
    "X": false
};
config.plugins.push(new webpack.DefinePlugin(defined));

module.exports = config;

