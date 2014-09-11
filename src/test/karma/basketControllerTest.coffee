expect = chai.expect

describe 'basket controller unit test', ->

  beforeEach ->
    module 'devoxx'
    localStorage['emails']=''

  it 'should find a basket controller', ->
    expect(@BasketController).not.to.equal null

  it 'should call the method inside a controller with no emails', inject ($controller, $httpBackend) ->
    $httpBackend.expectGET('/basket?emails=').respond ''

    controller = $controller 'BasketController'

    console.log 'woot !'

    $httpBackend.flush()

    expect(controller.emails).to.eql []

  it 'should call the method inside a controller with emails', inject ($controller, $httpBackend) ->
    localStorage['emails']='["foo@bar.com"]'
    $httpBackend.expectGET('/basket?emails=foo@bar.com').respond '{"test":0,"back":0,"database":0,"front":0,"hipster":0,"sum":0}'

    controller = $controller 'BasketController'

    $httpBackend.flush()

    expect(controller.emails).to.eql ['foo@bar.com']

  it 'should call the method add', inject ($controller, $httpBackend) ->
    $httpBackend.expectGET('/basket?emails=').respond ''
    $httpBackend.expectGET('/basket?emails=foo@bar.com').respond '{"test":0,"back":0,"database":0,"front":0,"hipster":0,"sum":0}'

    controller = $controller 'BasketController'
    controller.add 'foo@bar.com'

    $httpBackend.flush()

    expect(localStorage['emails']).to.eql '["foo@bar.com"]'
    expect(controller.emails).to.eql ['foo@bar.com']