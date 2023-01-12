export const environment = {
  production: true,
  keycloak: {
    url: 'https://instruweb-cd-keycloak.web.app:8484',
    realm: 'instruweb',
    clientId: 'front-end-service',
    redirectUri: 'https://instruweb-cd.web.app'
  }
};
