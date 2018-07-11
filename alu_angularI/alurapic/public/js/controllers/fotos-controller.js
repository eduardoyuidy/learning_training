angular.module('alurapic').controller('FotosController', function($scope, recursoFoto) {

    $scope.fotos = [];
    $scope.filtro = '';
    $scope.mensage = '';

    // Capturar fotos através de Resource
    recursoFoto.query(function(fotos){
        $scope.fotos = fotos;
    }, function(error){
        console.log(erro);
    });

    /** Utilizando recurso HTTP *****
    $http.get('v1/fotos')
    .success(function(fotos){
        $scope.fotos = fotos;
    })
    .error(function(erro) {
        console.log(erro);
    }); **/

    //Busca de lista através de Promise 
    /*
    var promise = $http.get('v1/fotos');
    promise.then(function(retorno) {
        $scope.fotos = retorno.data;
    }).catch(function(erro) {
        console.log(error);
    });*/    

    $scope.remover = function(foto) {

        // Remover a foto através de Resource
        recursoFoto.delete({fotoId: foto._id}, function() {
            var indiceFoto = $scope.fotos.indexOf(foto);
            $scope.fotos.splice(indiceFoto, 1);
            $scope.mensagem = 'Foto ' + foto.titulo + ' foi removida com sucesso!';
        }, function(erro) {
            console.log(erro);
            $scope.mensagem = 'Não foi possível remover a foto: ' + foto.titulo;
        });

        /**** // Remover a foto através de HTTP
        $http.delete('v1/fotos/' + foto._id)
        .success(function() {
            var indiceFoto = $scope.fotos.indexOf(foto);
            $scope.fotos.splice(indiceFoto, 1);
            $scope.mensagem = 'Foto ' + foto.titulo + ' foi removida com sucesso!';
        })
        .error(function(erro){
            console.log(erro);
            $scope.mensagem = 'Não foi possível remover a foto: ' + foto.titulo;
        }); *****/
    };
});