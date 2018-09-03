import { Negociacao, Negociacoes } from '../models/index';
import { MensagemView, NegociacoesView } from '../views/index';
import { domInject, throttle } from '../helpers/decorators/index';
import { NegociacaoService } from '../services/index';
import { imprime } from '../helpers/index';

let timer = 0;

export class NegociacaoController {

    //Utilizado o domInject para a estratégia de lazy loading, desta forma os elementos serão buscados do DOM apenas quando formos utilizados, evitando assim o carregamento desnecessário.
    @domInject('#data')
    private _inputData: JQuery;

    @domInject('#quantidade')
    private _inputQuantidade: JQuery;

    @domInject('#valor')
    private _inputValor: JQuery;

    // Quando realizada a inicialização da propriedade já em sua definição o typescript já infere o seu tipo, no caso como Negociacoes
    private _negociacoes: Negociacoes = new Negociacoes();
    private _negociacoesView: NegociacoesView = new NegociacoesView('#negociacoesView');
    private _mensagemView: MensagemView = new MensagemView('#mensagemView');

    private _service = new NegociacaoService();
    
    constructor() {

        //Casting explícito de um elemento mais genérico para um elemento mais específico
        //this._inputData = $('#data'); // Estratégia de lazy-loading, retiramos a importação do elemento do dom no Constructor.
        //this._inputQuantidade = $('#quantidade'); // Estratégia de lazy-loading, retiramos a importação do elemento do dom no Constructor.
        //this._inputValor = $('#valor'); // Estratégia de lazy-loading, retiramos a importação do elemento do dom no Constructor.

        //Executa a atualização da lista de negociações
        this._negociacoesView.update(this._negociacoes);
    }
    
    @throttle()
    adiciona(event: Event) {

        //Event passado para dentro do decorator throttle, pois como o decorator atrasa a execução do método, ele acaba atrasando tbm o event.prevent e dessa forma o submit do formulário eh executado.
        //event.preventDefault();

        let data = new Date(this._inputData.val().replace(/-/g,','));
        
        if (!this._ehDiaUtil(data)) {
            this._mensagemView.update('Negociações são aceitas apenas em dias da semana!');
            return;
        }

        const negociacao = new Negociacao(
            data, 
            parseInt(this._inputQuantidade.val()), 
            parseFloat(this._inputValor.val())
        );

        this._negociacoes.adiciona(negociacao);

        imprime(negociacao, this._negociacoes);

        //Este comando será executado mas não irá afetar a nossa lista de negociacoes, pois utilizamos a programação
        //defensiva para impedir que a lista de negociacoes seja alterada fora da classe de Negociacoes. Desta forma
        //não deixamos a referência da listagem exposta.
        this._negociacoes.paraArray().length = 0;

        //Executa a atualização da lista de negociações
        this._negociacoesView.update(this._negociacoes);
        this._mensagemView.update('Negociação adicionada com sucesso.');
    }

    private _ehDiaUtil(data: Date): boolean {

        return data.getDay() != DiaDaSemana.Sabado && data.getDay() != DiaDaSemana.Domingo;
    }

    //Decorator para evitar a repetição 'metralhar' de várias requisições ao backend da importação.
    @throttle() 
    async importaDados() {

        function isOk(res: Response){

            if (res.ok){
                return res;
            } else {
                throw new Error(res.statusText);
            }
        }

        try {
            
            const negociacoesParaImportar = await this._service
                .obterNegociacoes(isOk);
    
            const negociacoesJaImportadas = this._negociacoes.paraArray();
    
            negociacoesParaImportar
                .filter(negociacao => 
                    !negociacoesJaImportadas.some(jaImportada => 
                        negociacao.ehIgual(jaImportada)))
                .forEach(negociacao => {
                    this._negociacoes.adiciona(negociacao);
                });
            
            this._negociacoesView.update(this._negociacoes);
        } catch(err) {
            this._mensagemView.update(err.message);
        }
    }

    //Eyms-Teste-Zendesk
    /****
    buscaZendesk() {

        function isOk(res: Response){

            if (res.ok){
                return res;
            } else {
                throw new Error(res.statusText);
            }

        }

        //let request = new Request('https://totvssuporte.zendesk.com/api/v2/search.json?query=organization:T76547%20type:ticket%20subject:[51188]');
        let request: string = 'https://totvssuporte.zendesk.com/api/v2/search.json?query=organization:T76547%20type:ticket%20subject:[51188]';

        fetch(request, {
            headers: {
                "Access-Control-Allow-Origin": "*",
                "Access-Control-Allow-Headers": "Origin, Accept, Content-Type, Authorization, Access-Control-Allow-Origin",
                "Host": "totvssuporte.zendesk.com",
                "Cookie": "_zendesk_cookie=BAhJIkh7ImRldmljZV90b2tlbnMiOnsiNjYyNTU5ODMyOCI6IlFMVmN4aUwzZkVpNWpZNjc3UHZPOUtzRm95NUNWRFQ2In19BjoGRVQ%3D--91f05d60c86b36d74a1993219470ec1125c7127e; ajs_anonymous_id=%22c4a22aaa-d846-40c3-b344-82222e3eecbb%22; ajs_user_id=%226625598328%22; ajs_group_id=%22888110%22; _pendo_accountId.df3d609f-14a9-4a77-b441-73602a4aaab2=888110; _pendo_visitorId.df3d609f-14a9-4a77-b441-73602a4aaab2=6625598328; _ob_pub-9dc679b8d7a3ce7af1cebb6a169a466c=6625598328; _ga=GA1.2.1317130259.1530294805; __zlcmid=n9hSAWrcEDah7E; _pendo_meta.df3d609f-14a9-4a77-b441-73602a4aaab2=511210037; _gid=GA1.2.1412466784.1532354943; __cfduid=d50ee9361ae0117107afa3b2f885ccc7f1532355328; optimizelyEndUserId=oeu1532355331392r0.04353089826467671; _biz_uid=2a1336d34c43447d8e6e7f51600f83d8; _biz_flagsA=%7B%22Version%22%3A1%2C%22XDomain%22%3A%221%22%2C%22ViewThrough%22%3A%221%22%7D; flight=%7B%22first_touch_timestamp%22%3A1532355332008%2C%22last_touch_timestamp%22%3A1532355339628%2C%22first_referrer%22%3A%22https%3A%2F%2Ftotvssuporte.zendesk.com%2Fagent%2Fdashboard%22%2C%22last_referrer%22%3A%22https%3A%2F%2Ftotvssuporte.zendesk.com%2Fagent%2Fdashboard%22%2C%22first_landing_page%22%3A%22https%3A%2F%2Fwww.zendesk.com%2Ftalk%2F%22%2C%22last_landing_page%22%3A%22https%3A%2F%2Fwww.zendesk.com%2Ftalk%2F%22%2C%22time_on_site%22%3A20%2C%22total_time_on_site%22%3A38%2C%22page_views%22%3A4%2C%22visits%22%3A1%2C%22trials%22%3A0%2C%22domain%22%3A%22none%22%2C%22seenOffer%22%3Anull%7D; _biz_nA=3; _biz_pendingA=%5B%5D; _ceg.s=pcboyr; _ceg.u=pcboyr; _zendesk_shared_session=-cHg1bmNYMFlOKzhXVXZpNy9QZ29tYkNHd3VIaWNjdkI5cStlMjZVNXY5ZllJVUpnMWFPVmpLM1pJcUk3Z2pOODRvUUhlNTRYZGVORUxrakVueTIzVm5pdWMrL1dxd3NpZGVZaDNPUUlpckc1YXdUZWJmZmtCdy9iVGRiUGt4NDMtLVBQd21TbXVoU3ROYm8wM00zTzFYUVE9PQ%3D%3D--0f5845e71e97cdc38d6d40c44d0638043d39d169; _zendesk_authenticated=1; _zendesk_session=BAh7C0kiD3Nlc3Npb25faWQGOgZFVEkiJTUyZDE2YjE4ZWFkMzQwY2YwOWEzNzFjODdhZGJkNTE3BjsAVEkiDGFjY291bnQGOwBGaQMujQ1JIgpyb3V0ZQY7AEZpAwUPDEkiDmlzX21vYmlsZQY7AFRGSSITd2FyZGVuLm1lc3NhZ2UGOwBUewBJIhBfY3NyZl90b2tlbgY7AEZJIkVoSVVzU3BHdGpNdjZnaG54VWtlYTNaVHh5OFVoaHlldWRQMUZ3UmRWaDlYSnJmazBFTlBkM3FVR2tESy8rRi9OBjsARg%3D%3D--16a84dcba28a55e19f6e13d6dab2310ff0b0e775; _app_market_session=aSsySzFzbnJ3Tld0WWRDUVlNZmZPTUtsenF1dFludnZOanFteHJyYlVuS1BzU0R0bGJxbmpUSXFYaDNvOTQ0VFU5ZjRmOEw2eStwc0c4SXRkNSs5MnVPQmg4Y1I4YTJmS3U1bTEva0FCRDI4L2tNN2kxZkpORzRoVDFxR2RjZ0dlSXc5Y085OUtSRHVqbGpTY1lGVm1nPT0tLXNWbUlmck11dmVWdDZUUXlKYzJoZnc9PQ%3D%3D--79f52e62032b1d56f9f62a9ad5b0106ed89cc1cf"
            }
        })
            .then(res => isOk(res))
            .then(res => res.json())
            .then((dados: any[]) => {
                dados
                    .map(dado => {
                        console.log(dado);
                    })
                ;            
            })
            .catch(err => console.log(err.message));        
    }******/
}

//Uso de enumeradores
enum DiaDaSemana {
    Domingo, 
    Segunda,
    Terca, 
    Quarta,
    Quinta,
    Sexta, 
    Sabado
}