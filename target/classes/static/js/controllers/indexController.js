app.controller('indexCtrl', indexCtrl);

function indexCtrl($scope, $rootScope, $state){
    $scope.currentNavItem = '';

    $rootScope.$on('$stateChangeSuccess', function(event, toState, toParams, fromState, fromParams){
        console.log("Current nav item should be "+toState.name);
        $scope.currentNavItem = toState.name;
    });

    $scope.hideMain = function () {
        return sessionStorage.hash == null || sessionStorage.hash == "";
    };

    $scope.logout= function(){
        sessionStorage.hash = "";
        $state.transitionTo("login");
    }
}