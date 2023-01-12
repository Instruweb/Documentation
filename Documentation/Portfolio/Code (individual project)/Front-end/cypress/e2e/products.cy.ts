describe("get all products in a category", () => {
  beforeEach(() => {
    cy.visit("/category/1");
  });

  it("Should load", () => {
    cy.get('.card').should("have.length", 3)
  });
});
