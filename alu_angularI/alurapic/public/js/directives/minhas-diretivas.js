angular.module('minhasDiretivas', ['meusServicos'])
.directive('meuPainel', function() {

    // Directive Definition Object
    var ddo = {};

    // Restrição de uso da diretiva (E - Elemento / A - Atributo / C - Comentário)
    ddo.restrict = "AE"; // Atributo e Elemento

    //Escopo isolado da diretiva / quando @ o atributo deve ser igual ao atributo do objeto exemplo: titulo == titulo 
    // Quando @ o conteúdo é considerado em texto, quando & o conteúdo é considerado com expressão.
    // Quando = o conteúdo pode ser manipulado pela diretiva e pelo controller.
    ddo.scope = {
        titulo: '@'
    };

    //Identifica que o conteúdo interno da diretiva deve ser considerado, no html deve ser adicionado o atributo ng-transclude identificando o pai do conteúdo.
    ddo.transclude = true;

    //Importa o conteúdo do html para o template
    ddo.templateUrl = 'js/directives/meu-painel.html';

    /*ddo.template =     
            '<div class="panel panel-default">'
    +       '    <div class="panel-heading">'
    +       '        <h3 class="panel-title text-center">{{titulo}}</h3>'
    +       '    </div>'
    +       '    <div class="panel-body" ng-transclude>'
    +       '    </div>'
    +       '</div>';*/

    return ddo;
})
.directive('minhaFoto', function(){

    var ddo = {};

    ddo.restrict = "AE";

    ddo.scope = {
        titulo: '@',
        url: '@'
    }

    //ddo.transclude = true;

    ddo.templateUrl = 'js/directives/minha-foto.html';

    return ddo;
})
.directive('meuBotaoPerigo', function() {
    
    var ddo = [];

    ddo.restrict = 'E';

    ddo.scope = {
        nome: '@',
        acao: '&'
    }

    ddo.template = '<button ng-click="acao(foto)" class="btn btn-danger btn-block">{{nome}}</button>';

    return ddo;
})
.directive('meuFocus', function() {
    
    var ddo = {};

    ddo.restrict = 'A';

    /*
    ddo.scope = {
        focado: '='
    };
    */

    ddo.link = function(scope, element) {
        // Criação de watch - não performatico
        //scope.$watch('focado', function() {
        //    element[0].focus();
        //    scope.focado = false;
        //})

        scope.$on('fotoCadastrada', function() {
            element[0].focus();
        });
    }

    return ddo;
})
.directive('meusTitulos', function() {
    var ddo = {};

    ddo.restrict = 'E';

    ddo.template = '<ul><li ng-repeat="titulo in titulos">{{titulo}}</li></ul>';

    ddo.controller = function($scope, recursoFoto){
        recursoFoto.query(function(fotos) {
            $scope.titulos = fotos.map(function(foto){
                return foto.titulo;
            });
        })
    };

    return ddo;
});

//Exemplo Uso Directive
/*
<div meu-painel>
</div>

<meu-painel>
</meu-painel>*/

