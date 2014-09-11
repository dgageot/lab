angular.module 'devoxx', ['ngAnimate']

.controller 'BasketController', class
    constructor: (@$http)->
      @emails = JSON.parse(localStorage['emails'] || '[]')

      @basket = {}
      @refresh()

    add: (email) ->
      @emails.push email unless email in @emails
      @refresh()

    remove: (email) ->
      @emails = (mail for mail in @emails when mail isnt email)
      @refresh()

    refresh: ->
      localStorage['emails'] = JSON.stringify(@emails)
      @$http.get("/basket?emails=#{@emails}").success (data) =>
        @basket = data

    clear: ->
      @emails = []
      @refresh()

    showRemove: (email) ->
      email in @emails

.directive 'score', ->
    restrict: 'E'
    scope:
      value: '='
      category: '@'
    templateUrl: '/directives/score.html'
