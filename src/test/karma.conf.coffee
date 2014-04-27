# Karma configuration
# Generated on Thu Jan 30 2014 17:22:59 GMT+0100 (CET)

module.exports = (config) ->
  config.set
    basePath: ''
    frameworks: ['jasmine']
    files: [
      'bower_components/jquery/dist/jquery.min.js'
      'bower_components/angular/angular.min.js'
      'bower_components/angular-animate/angular-animate.min.js'
      'app/app.coffee'

      'bower_components/angular-mocks/angular-mocks.js',
      'node_modules/chai/chai.js',

      'src/test/karma/**/*.coffee',
    ]
    reporters: ['dots']
    port: 9876
    urlRoot: '/karma/'

    proxies: '/': 'http://localhost:8080/'
    colors: true
    logLevel: config.LOG_DEBUG

    browsers: ['ChromeCanary','Chrome','Safari','Firefox']
    captureTimeout: 60000

    autoWatch: true
    singleRun: false
    preprocessors:
      '**/*.coffee': ['coffee']
