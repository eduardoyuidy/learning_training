const BillingCycle = require('./billingCycle');

BillingCycle.methods(['get', 'post', 'put', 'delete']);

// Após executar um método PUT para realizar o UPDATE, deve retornar com o objeto NOVO e não o antigo, além disto, ativada a validação dos campos para o registro atualizado.
BillingCycle.updateOptions({ new: true, runValidators: true });

// Nova rota para retornar a quantidade de documentos na Collection BillingCycle.
BillingCycle.route('count', (req, res, next) => {

    BillingCycle.count((error, value) => {

        if (error) {
            res.status(500).json({errors: [error]});
        } else {
            res.status(200).json({value});
        }
    });
});

module.exports = BillingCycle;
