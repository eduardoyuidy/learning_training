import { RouterModule, Routes } from '@angular/router';

import { CadastroComponent } from './cadastro/cadastro.component';
import { ListagemComponent } from './listagem/listagem.component';

//Nas Rotas, quando definido ** significa que irá executar quando nenhuma outra rota foi informada (no caso '/' ou '/cadastro')
//Criada rota para cadastro/:id para receber um parâmetro pela url para edição de uma foto já existente.
const appRoutes: Routes = [
    {   path: '', component: ListagemComponent },
    {   path: 'cadastro', component: CadastroComponent },
    {   path: 'cadastro/:id', component: CadastroComponent },
    {   path: '**', component: ListagemComponent }
];

//Aqui é exportado as configurações de rotas definidas.
export const routing = RouterModule.forRoot(appRoutes);