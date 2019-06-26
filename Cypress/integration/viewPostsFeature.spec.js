
describe('Mainpage', () => {

    it('allows you to post a post and it is displays', function () {
        cy.visit('http://localhost:8080/')
        cy.get('[data-cy=addPostTxtBox]').type('Ant and Anna were here')
        cy.get('[data-cy=submitPost]').click()
        cy.get('[cy-data="postsContainer"] > :nth-child(1)').contains('Ant and Anna were here')
    });
});