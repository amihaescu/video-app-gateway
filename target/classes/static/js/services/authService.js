'use strict';
app.service('AuthService', authService);

function authService(){
    this.isAuthenticated = function(){
        return sessionStorage.hash;
    }
}
