/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.astec.model.utils;

import br.com.astec.model.entidades.LogFuncionario;
import br.com.astec.model.entidades.Venda;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Usuário
 */
public class GeradorRelatorio {
    public static File generateLogCsvFile(List<LogFuncionario> lista,String sFileName) throws IOException{

    Date data = new Date();
    SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyyHHmmss");

    
    char chars[] = sFileName.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if((chars[i]==' ')||(chars[i]==':')){
                chars [i] = '_';
            }
        }
     
    sFileName = new String (chars);
    
    String dataFormatada = formato.format(data);
    sFileName = sFileName+"_"+dataFormatada+".csv";
    File arquivo = new File(sFileName);
    FileWriter writer = new FileWriter(arquivo,true);

    writer.append("Cod. LOG:");
    writer.append(';');

    writer.append("Cod. USUARIO:");
    writer.append(';');

    writer.append("Tipo:");
    writer.append(';');

    writer.append("Cod. ITEM:");
    writer.append(';');

    writer.append("Acao:");
    writer.append(';');

    writer.append("Data/Hora:");
    writer.append("\n");

    for (LogFuncionario logFuncionario : lista) {
        writer.append(logFuncionario.getId().toString());
        writer.append(";");

        writer.append(logFuncionario.getIdFunc().toString());
        writer.append(";");

        writer.append(logFuncionario.getNomeTabela());
        writer.append(";");

        writer.append(logFuncionario.getIdItem().toString());
        writer.append(";");

        writer.append(logFuncionario.getAcao());
        writer.append(";");

        writer.append(logFuncionario.getDataAcao().toString());
        writer.append("\n");

    }




    writer.flush();
    writer.close();
    
    return arquivo;
    }
    public static File generateLogProdutoCsvFile(List<LogFuncionario> lista,String sFileName) throws IOException{

    Date data = new Date();
    SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyyHHmmss");

    
    char chars[] = sFileName.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if((chars[i]==' ')||(chars[i]==':')){
                chars [i] = '_';
            }
        }
     
    sFileName = new String (chars);
    
    String dataFormatada = formato.format(data);
    sFileName = sFileName+"_"+dataFormatada+".csv";
    File arquivo = new File(sFileName);
    FileWriter writer = new FileWriter(arquivo,true);

    writer.append("Cod. LOG:");
    writer.append(';');

    writer.append("Cod. USUARIO:");
    writer.append(';');

    writer.append("Nome do PRODUTO:");
    writer.append(';');

    writer.append("Cod. PRODUTO:");
    writer.append(';');

    writer.append("Acao:");
    writer.append(';');

    writer.append("Data/Hora:");
    writer.append(";");

    writer.append("Qntd. Efetuada:");
    writer.append("\n");

    for (LogFuncionario logFuncionario : lista) {
        writer.append(logFuncionario.getId().toString());
        writer.append(";");

        writer.append(logFuncionario.getIdFunc().toString());
        writer.append(";");

        writer.append(logFuncionario.getNomeTabela());
        writer.append(";");

        writer.append(logFuncionario.getIdItem().toString());
        writer.append(";");

        writer.append(logFuncionario.getAcao());
        writer.append(";");

        writer.append(logFuncionario.getDataAcao().toString());
        writer.append(";");

        writer.append(logFuncionario.getQntd().toString());
        writer.append("\n");

    }




    writer.flush();
    writer.close();
    
    return arquivo;
    }
    public static File generateVendaCsvFile(List<Venda> lista,String sFileName,double somaValores) throws IOException{

    Date data = new Date();
    SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyyHHmmss");

    
    char chars[] = sFileName.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if((chars[i]==' ')||(chars[i]==':')){
                chars [i] = '_';
            }
        }
     
    sFileName = new String (chars);
    
    String dataFormatada = formato.format(data);
    sFileName = sFileName+"_"+dataFormatada+".csv";
    File arquivo = new File(sFileName);
    FileWriter writer = new FileWriter(arquivo,true);

    writer.append("Cod. VENDA:");
    writer.append(';');
    
    writer.append("Cod. CLIENTE:");
    writer.append(';');

    writer.append("DATA:");
    writer.append(';');

    writer.append("VALOR TOTAL:");
    writer.append(';');

    writer.append("\n");

    for (Venda venda : lista) {
        writer.append(venda.getId().toString());
        writer.append(";");

        writer.append(venda.getClienteId().toString());
        writer.append(";");

        writer.append(venda.getDataCompra().toString());
        writer.append(";");

        writer.append(venda.getValorTotal().toString());
        writer.append("\n");

    }
    writer.append("VALOR TOTAL DE TODAS AS VENDAS:");
    writer.append(';');
    writer.append(""+somaValores);
    writer.append(';');
    writer.append("******");
    writer.append(';');
    writer.append("******");
    writer.append("\n");
    



    writer.flush();
    writer.close();
    
    return arquivo;
    }
}

