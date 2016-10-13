/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Imoveis;

import Imoveis.Imovel;
<<<<<<< HEAD
import Imoveis.salaComercial.SalaComercial;
import Imoveis.Predio;
=======
import Imoveis.apartamento.Apartamento;
import Imoveis.chacara.Chacara;
import Imoveis.salaComercial.SalaComercial;
import Imoveis.terreno.Terreno;
>>>>>>> 692898bd17da30a6c66a64fcc835ffcf25621228
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author junio
 */
public class ImobiliariaCrud implements ListaImoveis {

    private List<Imovel> listaImoveis;
    private Tipo tipoImovel;

    public ImobiliariaCrud() {
        listaImoveis = new ArrayList<>();
    }

    public List<Imovel> getListaImoveis() {
        return listaImoveis;
    }

    public Tipo getTipoImovel() {
        return tipoImovel;
    }

    public void setTipoImovel(Tipo tipoImovel) {
        this.tipoImovel = tipoImovel;
    }

    /**
     * metodo que inclui um objeto na lista geral de imoveis
     *
     * @param imovel que foi criado na interface
     * @return True caso inclua com sucesso, falso caso contrário
     */
    @Override
    public boolean incluir(Imovel imovel) {
        for (Imovel i : listaImoveis) {
            if (imovel.getCodigoObj() == i.getCodigoObj()) {
                return false;
            }
        }
        listaImoveis.add(imovel);
        escreverArquivo();
        return true;
    }

    @Override
    public Imovel consultar(int codigo) {
        for (Imovel imovel : listaImoveis) {
            if (imovel.getCodigoObj() == codigo) {
                return imovel;
            }
        }
        return null;
    }

    @Override
    public boolean editar(int codigo, Imovel im) {
        for (Imovel imovel : this.listaImoveis) {
            if (imovel.getCodigoObj() == codigo) {
                int indice = this.listaImoveis.indexOf(imovel);
                this.listaImoveis.set(indice, im);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean excluir(int codigo) {
        for (Imovel imovel : this.listaImoveis) {
            if (imovel.getCodigoObj() == codigo) {
                int indice = this.listaImoveis.indexOf(imovel);
                this.listaImoveis.remove(indice);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Imovel> ordenarCodigo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Imovel> ordenarValor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Imovel> ordenarArea() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Imovel> pesquisaValor(double valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Imovel> pesquisaBairro(String bairro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean escreverArquivo() {
        String dir = null;
        String fileName = "\\listaImoveis.csv";
        FileOutputStream outFile = null;
        BufferedWriter buff = null;
        String objProp = null;
        Imovel im;
        //abre o arquivo para escrita
        //A estrutura try-catch é usada pois o objeto BufferedWriter exige que as
        //excessões sejam tratadas
        try {

            if (tipoImovel.getTipo() == 1) {
                dir = dirName("apartamento");
                im = new Apartamento();
                objProp = objProp(im);
            } else if (tipoImovel.getTipo() == 2) {
                dir = dirName("chacara");
                im = new Chacara();
                objProp = objProp(im);
            } else if (tipoImovel.getTipo() == 3) {
                dir = dirName("sala_comercial");
                im = new SalaComercial();
                objProp = objProp(im);
            } else if (tipoImovel.getTipo() == 4) {
                dir = dirName("terreno");
                im = new Terreno();
                objProp = objProp(im);
            }

            File files = new File(dir);
            if (!files.exists()) {
                if (files.mkdirs()) {
                } else {
                    return false;
                }
            }
            outFile = new FileOutputStream(dir + fileName);
            //Criação de um buffer para a escrita em uma stream
            buff = new BufferedWriter(new FileWriter(dir + fileName));
            //escreve o número de contas na primeira linha do arquivo
            //buff.write(listaImoveis.size() + ",");
            //escreve as informações de cada conta
            buff.write("codigo," + objProp);
            for (Imovel imovel : listaImoveis) {
                //escreve o numero e saldo
<<<<<<< HEAD
                buff.write(listaImoveis.toString() + "\n");
=======
                buff.write("\n");
                buff.write(objToString(imovel));
                //escreve uma linha em branco entre uma conta e a seguinte
                buff.write("\n");
>>>>>>> 692898bd17da30a6c66a64fcc835ffcf25621228
            }
            // fecha o arquivo
            buff.close();
            outFile.close();
            return true;

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean lerArquivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String dirName(String tipo) {
        Properties p = System.getProperties();
        return p.getProperty("user.home") + "\\projetoRPII\\" + tipo;
    }

    private String objProp(Imovel im) {
        String prop = im.toString();
        String[] props = prop.split("\n");
        String propsaux = "";
        for (int x = 0; x < props.length; x++) {
            if (x != 0) {
                propsaux += props[x].split(":")[0];
            }
            if (x != props.length - 1 && x != 0) {
                propsaux += ";";
            }

        }
        return propsaux;
    }

    private String objToString(Imovel im) {
        String prop = im.toString();
        String[] props = prop.split("\n");
        String propsaux = "";
        propsaux += im.getCodigoObj() + ";";
        for (int x = 0; x < props.length; x++) {
            if (x != 0) {
                propsaux += props[x].split(":")[1];
            }
            if (x != props.length - 1 && x != 0) {
                propsaux += ";";
            }

        }
        return propsaux;
    }

}
