# Angular, NgRx and Angular Material Starter 
by [@tomastrajan](https://twitter.com/tomastrajan)

[![license](https://img.shields.io/github/license/tomastrajan/angular-ngrx-material-starter.svg)](https://github.com/tomastrajan/angular-ngrx-material-starter/blob/master/LICENSE) [![All Contributors](https://img.shields.io/badge/all_contributors-25-orange.svg?style=flat-square)](#contributors) [![code style: prettier](https://img.shields.io/badge/code_style-prettier-ff69b4.svg)](https://github.com/prettier/prettier) [![Build Status](https://travis-ci.org/tomastrajan/angular-ngrx-material-starter.svg?branch=master)](https://travis-ci.org/tomastrajan/angular-ngrx-material-starter) [![Twitter Follow](https://img.shields.io/twitter/follow/tomastrajan.svg?style=social&label=Follow)](https://twitter.com/)


![intro](https://raw.githubusercontent.com/tomastrajan/angular-ngrx-material-starter/master/meta-assets/intro.png)
![themes](https://raw.githubusercontent.com/tomastrajan/angular-ngrx-material-starter/master/meta-assets/themes.png)


## Getting started
```bash
git clone https://github.com/tomastrajan/angular-ngrx-material-starter.git new-project
cd new-project
npm install
npm start
```

## Useful Commands
  * `npm start` - starts a dev server and opens browser with running app
  * `npm run test` - runs lint and tests
  * `npm run watch` - runs tests in watch mode
  * `npm run cy:open` - opens the Cypress Test Runner in interactive mode
  * `npm run cy:run` - runs Cypress tests via the cli
  * `npm run prod` - runs full prod build and serves prod bundle
  * `npm run prettier` - runs prettier to format whole code base (`.ts` and `.scss`) 
  * `npm run analyze` - runs full prod build and `webpack-bundle-analyzer` to visualize how much code is shipped (dependencies & application) 

![analzye](https://raw.githubusercontent.com/tomastrajan/angular-ngrx-material-starter/master/meta-assets/analyze.png)
## Run Inside Docker Container
  * `docker build -t material-starter .` - builds docker image with name `material-starter`
  * `docker run -it \
   -v ${PWD}:/usr/src/app \
   -v /usr/src/app/node_modules \
   -p 4200:4200 \
   --rm \
   material-starter` - starts `material-starter` container (you can access running application browsing http://localhost:4200) 

 
## Features

* custom themes support (4 themes included)
* lazy-loading of feature modules
* lazy reducers
* localStorage ui state persistence
* `@ngrx/effects` for API requests
* fully responsive design
* angular-material and custom components in `SharedModule`
* Cypress for end to end tests
 
## Stack

* Angular
* ngrx (or try [ngx-model](https://github.com/tomastrajan/ngx-model) if you prefer less boilerplate)
* Angular Material
* Bootstrap 4 (only reset, utils and grids)

## Troubleshooting

* **Blocking at emitting LicenseWebpackPlugin when npm start** - try using [cnpm](https://github.com/cnpm/cnpm) instead of npm

