



import java.util.ArrayList;
import java.util.Stack;
import jdk.nashorn.internal.ir.BreakNode;

/**
 *
 * @author Gabriele
 */
public class BuscaProfundidade {

    private Stack<No>     fronteira = new Stack<>();
    private ArrayList<No> removidosFronteira = new ArrayList<>();
    static ArrayList<No> caminho = new ArrayList<>();
    static int           NumerodeNos=0;

    public BuscaProfundidade() {

    }

    public static int getNumerodeNos() {
        return NumerodeNos;
    }

    public static void setNumerodeNos(int NumerodeNos) {
        BuscaProfundidade.NumerodeNos = NumerodeNos;
    }

    public boolean Busca(No noInicial, int limite) {

        ArrayList<No> noArray = new ArrayList<>();
      //inserir no inicial na fronteira
        fronteira.push(noInicial);

        No noBusca;

        while (!fronteira.isEmpty()) {
            NumerodeNos++;
            //remove o no da fronteira
            noBusca = fronteira.pop();

            removidosFronteira.add(noBusca);
            System.out.println("\nA procura: \n");
            //testa se o no removido é objetivo, retorna e sai do loop
            if (noBusca.getEstado().Objetivo(noBusca.getEstado().getMatriz())) {
                    System.out.println("\nAchei: \n");
                    ImprimeCaminho(noBusca);
                    return true;
                }
            //criar um array list que recebe os nós' removidos da fronteira, 
            //e o atributo pai dos sucessores que forem gerados desse no que foi removido, sera o indice desse no no array list
            
            
            if (noBusca.getProfundidade() < limite) {
                 //gera sucessores e depois insere na fronteira
                fronteira.addAll(noBusca.GeraSucessores(removidosFronteira.size() - 1));
               }}
              return false;}
        
         public void ImprimeCaminho(No no){ 
        if (no.getPai()!=-1){
            ImprimeCaminho(removidosFronteira.get(no.getPai()));
            caminho.add(no);
        }
        System.out.println("Pai: " + no.getPai());
            no.getEstado().ImprimirEstado();}
        
      public Stack<No> getFronteira() {
        return fronteira;
    }

    public void setFronteira(Stack<No> fronteira) {
        this.fronteira = fronteira;
    }

    public ArrayList<No> getRemovidosFronteira() {
        return removidosFronteira;
    }

    public void setRemovidosFronteira(ArrayList<No> removidosFronteira) {
        this.removidosFronteira = removidosFronteira;
    }

}
