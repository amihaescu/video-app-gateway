'use strict';
app.factory('sharedScope', function () {
    var movie;

    return {
        setMovie: function (value) {
            movie = value;
        },
        getMovie: function () {
            return movie;
        }
    };
});
