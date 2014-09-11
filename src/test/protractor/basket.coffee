describe 'End to end test', ->
  beforeEach ->
    browser.get '/'

  it 'should update the basjet with two developers', ->
    find('#clear').click()
    find('#David .add').click()
    find('#Mathilde .add').click()

    expect(find('#basket .price').getText()).toContain '1700'

  it 'should find the right number of front skill for dgageot', ->
    find('#clear').click()
    find('#David .add').click()

    element.all(By.css('.front:not(.ng-hide)')).then (array) -> expect(array.length).toEqual 2
    element.all(By.css('.back:not(.ng-hide)')).then (array) -> expect(array.length).toEqual 1
    element.all(By.css('.database:not(.ng-hide)')).then (array) -> expect(array.length).toEqual 0
    element.all(By.css('.test:not(.ng-hide)')).then (array) -> expect(array.length).toEqual 1
    element.all(By.css('.hipster:not(.ng-hide)')).then (array) -> expect(array.length).toEqual 1
    find('#David .btn-success').click()
    expect(find('#basket .text-right').getText()).toContain '1000'
