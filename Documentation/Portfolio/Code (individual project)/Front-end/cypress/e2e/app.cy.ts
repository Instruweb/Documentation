describe("login using keycloak", () => {
  it("login using nickwelles account", () => {
    cy.visit("/home");
    cy.get('.login-btn').click()
    cy.get('[id="username"]').type(Cypress.env('CYPRESS_USERNAME'));
    cy.get('[id="password"]').type(Cypress.env('CYPRESS_PASSWORD'));
    cy.get('[id="kc-login"]').click();
  });

  it("Contains not found", () => {
    cy.visit("/ditbestaatniet");
    cy.get('.not-found-title').should("have.text", "Page Not Found");
  });

  it("Contains 4 main categories", () => {
    cy.visit("/home");
    cy.get('.col-3').should('have.length', 4);
  });
});
