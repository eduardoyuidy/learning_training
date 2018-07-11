angular.module('alurapic').controller('FotoController', function($scope, cadastroDeFotos, recursoFoto, $routeParams){

    $scope.foto = {};
    $scope.mensagem = '';

    if ($routeParams.fotoId) {

        //Capturando a foto através de Resource
        recursoFoto.get({fotoId: $routeParams.fotoId}, function(foto) {
            $scope.foto = foto;
        }, function(erro) {
            console.log(erro);
            console.log('Não foi possível obter a foto de ID : ' + $routeParams.fotoId);
        })

        /**** // Capturando a foto através de HTTP
        $http.get('v1/fotos/' + $routeParams.fotoId)
        .success(function(foto) {
            $scope.foto = foto;
        })
        .error(function(erro){
            console.log(erro);
            console.log('Não foi possível obter a foto de ID : ' + $routeParams.fotoId);
        });****/
    }
    
    $scope.submeter = function() {

        if($scope.formulario.$valid) {

            cadastroDeFotos.cadastrar($scope.foto)
            .then(function(dados){
                $scope.mensagem = dados.mensagem;

                if(dados.inclusao){
                    $scope.foto = {};
                    $scope.formulario.$setPristine();
                }

                // Setar o focado true para uso com whatchers
                //$scope.focado = true;                 
            })
            .catch(function(dados){
                $scope.mensagem = dados.mensagem;
            })            

            // Lógica de uso com Resource 
            //if($scope.foto._id) {
            //
            //    recursoFoto.update({fotoId: $scope.foto._id}, $scope.foto, function(){
            //        $scope.mensagem = 'A foto ' + $scope.foto.titulo + ' foi alterada com sucesso. ';
            //    }, function(erro){
            //        console.log(erro);                    
            //        $scope.mensagem = 'Não foi possível alterar a foto ' + $scope.foto.titulo;
            //    });
            //    
            //    /**** // Atualização através de HTTP com o método PUT 
            //    $http.put('v1/fotos/' + $scope.foto._id, $scope.foto)
            //    .success(function(){                    
            //        $scope.mensagem = 'A foto ' + $scope.foto.titulo + ' foi alterada com sucesso. ';
            //    })
            //    .error(function(erro){
            //        console.log(erro);                    
            //        $scope.mensagem = 'Não foi possível alterar a foto ' + $scope.foto.titulo;
            //    });****/
            //} else {
            //    
            //    // Adicionando uma foto através de Resource método Save
            //    recursoFoto.save($scope.foto, function(){
            //        $scope.foto = {};
            //        $scope.formulario.$setPristine();
            //        $scope.mensagem = 'Foto incluída com sucesso';
            //    }, function(erro){
            //        $scope.mensagem = 'Não foi possível incluir a foto';
            //        console.log(erro);
            //    });
            //
            //    /**** // Adicionando uma nova foto através de HTTP método POST
            //    $http.post('v1/fotos', $scope.foto)
            //    .success(function (){
            //        $scope.foto = {};
            //        $scope.formulario.$setPristine();
            //        $scope.mensagem = 'Foto incluída com sucesso';
            //    })
            //    .error(function(erro){
            //        $scope.mensagem = 'Não foi possível incluir a foto';
            //        console.log(erro);
            //    }) *****/
            //}  

        } // if - $scope.formulario.$valid
    };
});