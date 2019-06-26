/// <reference types="Cypress" />

describe('Mainpage', () => {

    beforeEach(function () {
        // "this" points at the test context object
        cy.fixture('postsFixture').as('postsJSON')
        cy.server()
        cy.route({
            method: 'GET',      // Route all GET requests
            url: '**/api/posts/search/findAllOrderByPostedTimeDesc',    // that have a URL that matches '/users/*'
            response: '@postsJSON'        // and force the response to be: []
        }).as('posts')
    });

    it('can recieve a non empty reply from the API', function () {
        // this.user exists
        cy.visit('http://localhost:8080/')
        cy.wait('@posts').then((xhr) => {
            assert.isNotNull(xhr.response.body.data, 'list posts API call has data')
        })
    });

    it('displays a post', function () {
        cy.visit('http://localhost:8080/')
        cy.wait("@posts")
        cy.contains('hola chicas')
    });
});