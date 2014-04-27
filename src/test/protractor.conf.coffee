require('coffee-script').register()

exports.config =
  specs: ['src/test/protractor/**/*.coffee']
  baseUrl: 'http://localhost:8080'
  onPrepare: ->
    global.By = global.by
    global.find = (selector) ->
      global.element(By.css(selector))
