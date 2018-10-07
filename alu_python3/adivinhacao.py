import random

def jogar():
    print("**********************************")
    print("Bem vindo ao jogo de Adivinhação!!")
    print("**********************************")

    ##numero_secreto = round(random.random() * 100)
    numero_secreto = random.randrange(1,101)
    total_de_tentativas = 0
    pontos = 1000

    print("Qual nível de dificuldade?", numero_secreto)
    print("(1) Fácil (2) Médio (3) Difícil")
    nivel_dificuldade = int(input("Defina  o nível:"))

    if(nivel_dificuldade == 1):
        total_de_tentativas = 20
    elif (nivel_dificuldade == 2):
        total_de_tentativas = 10
    else:
        total_de_tentativas = 5

    for tentativa in range(1,total_de_tentativas + 1):
        print('Tentativa {} de {}'.format(tentativa, total_de_tentativas))
        chute_string = input("Digite o seu número entre 1 e 100: ")
        print("Você Digitou : ", chute_string)
        chute = int(chute_string)

        if chute < 1 or chute > 100:
            print('Você deve digitar um número entre 1 e 100')
            continue

        acertou = chute == numero_secreto
        maior = chute > numero_secreto
        menor = chute < numero_secreto

        if(acertou):
            print("Você acertou e fez {} pontos!!!".format(pontos))
            break
        else:
            if maior:
                print("Você errou! O seu chute foi maior que o número secreto.")
            elif menor:
                print("Você errou! O seu chute foi menor que o número secreto.")
            pontos_perdidos = abs(numero_secreto - chute)
            pontos = pontos - (pontos_perdidos)

    print("Fim do Jogo!!", "Número sorteado era", numero_secreto)

# A variável __name__ recebe a informação '__main__' quando o módulo é chamado diretamente, caso seja feito import ele conterá o nome do módulo importado.
if(__name__ == "__main__"):
    jogar()