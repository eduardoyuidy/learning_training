import random

def jogar():

    imprime_mensagem_abertura()
    palavra_secreta = carrega_palavra_secreta(nome_arquivo = 'palavras.txt')

    letras_acertadas = inicializa_letras_acertadas(palavra_secreta)
    print(letras_acertadas)

    erros = 0

    while(True):
        chute = pede_chute()

        if (chute in palavra_secreta):
            marca_chute_correto(chute, letras_acertadas, palavra_secreta)
        else:
            erros += 1
            desenha_forca(erros)

        print(letras_acertadas)

        # enforcou = erros == 6
        if (erros == 7 or "_" not in letras_acertadas):
            break

    if("_" not in letras_acertadas):        
        imprime_mensagem_vencedor()
    else:
        imprime_mensagem_perdedor(palavra_secreta)

def imprime_mensagem_abertura():
    print("**********************************")
    print("Bem vindo ao jogo de Forca!!")
    print("**********************************")

def carrega_palavra_secreta(nome_arquivo = 'palavras.txt'):
    palavras = []
    with open(nome_arquivo, 'r') as arquivo:
        for linha in arquivo:
            linha = linha.strip().upper()
            palavras.append(linha)

    palavra_secreta = palavras[random.randrange(0, len(palavras))]
    palavra_secreta = palavra_secreta.strip()
    return palavra_secreta

def inicializa_letras_acertadas(palavra):
    return ["_" for letra in palavra]

def pede_chute():
    chute = input('Qual a letra? ')
    chute = chute.strip().upper()
    return chute

def marca_chute_correto(chute, letras_acertadas, palavra_secreta):
    index = 0
    for letra in palavra_secreta:
        if (chute.upper() == letra.upper()):
            letras_acertadas[index] = letra.upper()
        index += 1

def imprime_mensagem_vencedor():
    print("Parabéns, você ganhou!")
    print("       ___________      ")
    print("      '._==_==_=_.'     ")
    print("      .-\\:      /-.    ")
    print("     | (|:.     |) |    ")
    print("      '-|:.     |-'     ")
    print("        \\::.    /      ")
    print("         '::. .'        ")
    print("           ) (          ")
    print("         _.' '._        ")
    print("        '-------'       ")

def imprime_mensagem_perdedor(palavra_secreta):
    print("Puxa, você foi enforcado!")
    print("A palavra era {}".format(palavra_secreta))
    print("    _______________         ")
    print("   /               \       ")
    print("  /                 \      ")
    print("//                   \/\  ")
    print("\|   XXXX     XXXX   | /   ")
    print(" |   XXXX     XXXX   |/     ")
    print(" |   XXX       XXX   |      ")
    print(" |                   |      ")
    print(" \__      XXX      __/     ")
    print("   |\     XXX     /|       ")
    print("   | |           | |        ")
    print("   | I I I I I I I |        ")
    print("   |  I I I I I I  |        ")
    print("   \_             _/       ")
    print("     \_         _/         ")
    print("       \_______/           ")

def desenha_forca(erros):
    print("  _______     ")
    print(" |/      |    ")

    if(erros == 1):
        print(" |      (_)   ")
        print(" |            ")
        print(" |            ")
        print(" |            ")

    if(erros == 2):
        print(" |      (_)   ")
        print(" |      \     ")
        print(" |            ")
        print(" |            ")

    if(erros == 3):
        print(" |      (_)   ")
        print(" |      \|    ")
        print(" |            ")
        print(" |            ")

    if(erros == 4):
        print(" |      (_)   ")
        print(" |      \|/   ")
        print(" |            ")
        print(" |            ")

    if(erros == 5):
        print(" |      (_)   ")
        print(" |      \|/   ")
        print(" |       |    ")
        print(" |            ")

    if(erros == 6):
        print(" |      (_)   ")
        print(" |      \|/   ")
        print(" |       |    ")
        print(" |      /     ")

    if (erros == 7):
        print(" |      (_)   ")
        print(" |      \|/   ")
        print(" |       |    ")
        print(" |      / \   ")

    print(" |            ")
    print("_|___         ")
    print()

# A variável __name__ recebe a informação '__main__' quando o módulo é chamado diretamente, caso seja feito import
# ele conterá o nome do módulo importado.
if(__name__ == "__main__"):
    jogar()
