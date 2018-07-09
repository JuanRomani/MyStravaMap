angular.module('stravaMap', [])
    .controller('athleteData', function($scope, $http) {
        $http.get('/stravamap').
        then(function(response) {
            $scope.athleteData = response.data;

            var map = L.map('map').setView([-32.9499, -60.6960], 12);

            /*L.tileLayer('https://{s}.tile.openstreetmap.se/hydda/full/{z}/{x}/{y}.png', {
                maxZoom: 16,
                attribution: 'Tiles courtesy of <a href="http://openstreetmap.se/" target="_blank">OpenStreetMap Sweden</a> &mdash; Map data &copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
            }).addTo(map);*/

            L.tileLayer('https://cartodb-basemaps-{s}.global.ssl.fastly.net/dark_all/{z}/{x}/{y}{r}.png', {
                attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a> &copy; <a href="http://cartodb.com/attributions">CartoDB</a>',
                subdomains: 'abcd',
                maxZoom: 19
            }).addTo(map);

            var encodedRoutes = response.data.routes;

            for (let encoded of encodedRoutes) {
                var coordinates = L.Polyline.fromEncoded(encoded).getLatLngs();

                L.polyline(
                    coordinates,
                    {
                        color: '#fc4c02',
                        weight: 1.22,
                        opacity: .22,
                        lineJoin: 'round',
                        interactive: false
                    }
                ).addTo(map);
            }
        });
    });

