describe("get one product", () => {
  it("Should load one product", () => {
    cy.visit("/products/detail/1");
    cy.get('.product_title').should("have.text", "Fazley Outlaw Series Sheriff Basic HH Green elektrische gitaar met gigbag")
  });

  it("Visit a product by navigating from the home page", () => {
    Cypress.config('defaultCommandTimeout', 10000);
    cy.visit('/');
    cy.contains('Alle categorieën').click();
    cy.window()
      .its('performance')
      .invoke('mark', 'pageOpen')

    cy.contains("Gitaren").click();
    cy.contains("More info").click();
    cy.get('.product_title').should("have.text", "Fazley Outlaw Series Sheriff Basic HH Green elektrische gitaar met gigbag")

    cy.window()
      .its('performance')
      .invoke('measure', 'pageOpen')
  });
});
