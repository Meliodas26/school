
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class main extends javax.swing.JFrame {
    String [][] etiquetasBn, variablesBn;
    int sizeTemp, fEtiquetas = 0, fVar = 0, sizeVar;
    int cCaso3 = 0;
    private DefaultTableModel model;
    private DefaultTableModel model2;
    
    public main() {
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
        jTextArea1.setText("SEGMENT SS\n"
                + "inicio\nsuma\nresta\nresultados\nmain\n"
                + "END SS\n"
                + "SEGMENT DS\n"
                + "ciclo dw 1\nopc dw -1\nopcSuma dw 1\nopcResta dw 2\nopcResultado dw 3\n"
                + "mns1 db \"Resultados \"\nmns2 db \"Suma:\"\nmns3 db \"Resta:\"\n"
                + "resSuma dw \nresResta dw \nop1 dw 2\nop2 dw 3\n"
                + "END DS\n"
                + "SEGMENT CS\n"
                + "inicio:\nmov ax,opc\nadd ax,1\nmov opc,ax\n"
                + "Suma: \ncmp opc,opcSuma\nmov ax,op1\nadd ax,op2\nmov resSuma,ax\n"
                + "Resta:\ncmp opc,opcResta\nmov bx,op1\nmov ax,bx\nsub ax,op2\nmov bx,ax\nmov resResta,bx\n"
                + "Resultados:\ncmp opc,3\nmov dx, offset mns1\nmov dx, offset mns2\nmov ax,offset op1\nmov dx,offset '+'\nmov bx,offset op2\nmov dx,offset '='\nmov ax,offset resSuma\nmov dx,offset mns3\nmov ax,offset op1\nmov dx,offset '-'\nmov bx,offset op2\nmov dx,offset '='\nmov ax,offset resResta\nmov dx,offset 'Adios'\nmov ciclo,0\n"
                + "main:\nloop cmp ciclo,1\n"
                + "JNZ inicio\n"
                + "END CS");
        String data[][] = {};
        String col[] = {"Etiqueta", "Linea"};
        model = new DefaultTableModel(data,col);
        jTable1.setModel(model);
        
        String colV[] = {"Variable", "Tipo", "Valor"};
        model2 = new DefaultTableModel(data,colV);
        jTable2.setModel(model2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        label1 = new java.awt.Label();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ensamblador MASM611");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setBackground(new java.awt.Color(0, 153, 51));
        jButton1.setText("Analizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextPane1.setBackground(new java.awt.Color(12, 12, 12));
        jTextPane1.setBorder(null);
        jTextPane1.setForeground(new java.awt.Color(255, 51, 51));
        jTextPane1.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportView(jTextPane1);

        label1.setForeground(new java.awt.Color(0, 51, 204));
        label1.setText("Errores:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Etiqueta", "Linea"
            }
        ));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
        }

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(jTable2);

        label2.setForeground(new java.awt.Color(153, 0, 0));
        label2.setText("Etiquetas");

        label3.setForeground(new java.awt.Color(0, 0, 0));
        label3.setText("Variables:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 35, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
                        .addGap(1, 1, 1)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Para limpiar las tablas
        if(fEtiquetas != 0){
            limpiarEtiquetas();
        }
        if(fVar != 0){
            limpiarVar();
        }
        
        automata        amta        = new automata();
        variables       variables   = new variables();
        etiquetas       etiqueta    = new etiquetas();
        pReservadas     pReservadas = new pReservadas();
        cCaso3 = 0;
        
        int [] nS;
        int nLinea =0, nErrores=0, estado = 0;
        String codigo, linea, palabra, error="", nCodigo="", errores="";
        boolean bnError=false, bnSegment=false, endCs=false, ss=false, ds=false, cs= false;
        boolean bnBreak =false, bnVariable = false, bnEtiqueta = false, bnPReservadas = false;
        boolean salto = false ;
        
        int bnLinea = 0;
        codigo = jTextArea1.getText();
        
        /*
        StringTokenizer numerolineas = new StringTokenizer(codigo,"|");
        String codigoAux = "";
        String numero = "";
        if(codigo.contains("|")){
            String codigoTemp = "";
            while(numerolineas.hasMoreTokens()){
                numero =    numerolineas.nextToken();
                //System.out.println(numerolineas.nextToken());
                //System.out.println(numerolineas.nextToken());
                codigoAux = numerolineas.nextToken();
                System.out.println(numero);
                System.out.println(codigoAux);
                codigoTemp = codigoTemp+codigoAux+"\n";
                //codigoAux = codigoAux+numerolineas.nextToken();
                //System.out.println(codigoAux);
                
            }
            System.out.println(codigoTemp);
        }
        */
        
        
        
        codigo = codigo.toUpperCase();
        StringTokenizer tnLinea = new StringTokenizer(codigo, "\n");
        while(tnLinea.hasMoreTokens()){
            nLinea++;
            if(bnBreak){
                errores = (nLinea-2)+"|Falto cerrar el segmento\n";
                break;
            }else{
            linea = tnLinea.nextToken();
            bnLinea = linea.indexOf("|");
            if(bnLinea == -1) {
                nCodigo = nCodigo+nLinea+"|"+linea+"\n";
            }else{
                
                
            }
            //System.out.println(linea);
            StringTokenizer tnPalabra = new StringTokenizer(linea, " ");
            while(tnPalabra.hasMoreTokens()){
                palabra = tnPalabra.nextToken();
                //System.out.println(palabra);    
                switch (palabra){
                    case "SEGMENT":
                        //bnSegment = amta.getBnSegment();
                        bnSegment=true;
                        break;
                    default:
                        if(!(bnSegment)){
                            if(!(palabra.equals(""))){
                                nErrores++;
                                errores = errores+nLinea+"|Instruccion fuera de su segmento\n";
                            }
                        }
                }
                
                if(bnSegment){
                    bnSegment = amta.segment(palabra, nLinea);
                    error = amta.getError();
                    if(!(error.equals(""))){
                        bnError =true;
                        //System.out.println(bnSegment);
                    }
                    if(bnError){
                        nErrores++;
                        //System.out.println(error);
                        errores = errores+error+"\n";
                        error="";
                        bnSegment = false;
                        bnError = false;
                    }
                }
                estado = amta.getSdoEstado();
                switch(estado){
                    case 1:
                        etiqueta.automata(nLinea, linea);
                        bnEtiqueta = true;
                        break;
                    case 2:
                        int sizeEtiquetas = etiqueta.getSize();
                        String [][] etiquetas = etiqueta.getEtiquetas();
                        variables.setEtiquetas(etiquetas, sizeEtiquetas);
                        
                        variables.automata(nLinea, linea);
                        variablesBn = variables.getVariables();
                        sizeVar = variables.getSizeArray();
                        bnVariable = true;
                        break;
                    case 3:
                        cCaso3++;
                        if(cCaso3 == 1){
                            String [][] arrayTemp = etiqueta.getEtiquetas();
                            sizeTemp = etiqueta.getSize();
                            etiquetasBn = new String [sizeTemp][3];
                            for(int cicloEtiquetas = 0; cicloEtiquetas < sizeTemp; cicloEtiquetas++){
                                etiquetasBn[cicloEtiquetas][0] = arrayTemp[cicloEtiquetas][0];
                                etiquetasBn[cicloEtiquetas][1] = arrayTemp[cicloEtiquetas][1];
                                etiquetasBn[cicloEtiquetas][2] = "F";
                            }
                        }
                        salto = pReservadas.getSalto();
                        StringTokenizer saltoT;
                        saltoT = new StringTokenizer (linea," ");
                        String pR = saltoT.nextToken();
                        if(salto){
                            
                        }
                        if(pR.equals("JNZ")){
                            String [][] array = etiqueta.getEtiquetas();
                            int size = etiqueta.getSize();
                            pReservadas.jnz(linea, nLinea, array, size);
                            if(salto){
                                salto = false;
                                pReservadas.setSalto(salto);
                            }
                            error = pReservadas.getErrores();
                            if(error.equals("")){
                                StringTokenizer espacios = new StringTokenizer(linea, " ");
                                espacios.nextToken();
                                String etiquetaComparacion = espacios.nextToken();
                                boolean errorEtiqueta = true;
                                for(int ciclo = 0; ciclo < sizeTemp; ciclo++){
                                    if(etiquetaComparacion.equals(etiquetasBn[ciclo][0])){
                                        if(etiquetasBn[ciclo][2].equals("V")){
                                            errorEtiqueta = false;
                                        }
                                        break;
                                    }
                                }
                                if(errorEtiqueta){
                                    nErrores++;
                                    errores = errores+nLinea+"|Error de ambiguedad: No existe segmento de codigo asignado con esa etiqueta\nNota: Primero va el codigo y despues el JNZ\n";
                                    
                                }
                            }
                        }else{
                            if(!salto){
                                if(linea.contains(":")){
                                    String etiquetaComparacion = linea;
                                    char [] letrasEtiqueta = etiquetaComparacion.toCharArray();
                                    int puntos = 0;
                                    for(int l = 0; l<etiquetaComparacion.length(); l++){
                                        String letra = Character.toString(letrasEtiqueta[l]);
                                        if(":".equals(letra)){
                                            puntos++;
                                            int ultimo = etiquetaComparacion.length()-1;
                                            //String aux = Character.toString(letrasEtiqueta[l+1][]);
                                            if(l != ultimo){
                                                for(int espacios = l+1; espacios < etiquetaComparacion.length(); espacios++){
                                                    letra = Character.toString(letrasEtiqueta[espacios]);
                                                    if(!letra.equals(" ")){
                                                        nErrores++;
                                                        errores = errores+nLinea+"|Error de sintaxis: Etiqueta + :\n"; 
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if(!(puntos>1)){
                                        StringTokenizer espacios = new StringTokenizer(etiquetaComparacion, ":");
                                        if(espacios.hasMoreTokens()){
                                            etiquetaComparacion = espacios.nextToken();
                                        }else{
                                            nErrores++;
                                            errores = errores+nLinea+"|Error de sintaxis: Etiqueta + :\n"; 
                                        }
                                        espacios = new StringTokenizer(etiquetaComparacion, " ");
                                        if(espacios.hasMoreTokens()){
                                            etiquetaComparacion = espacios.nextToken();
                                        }else{
                                            nErrores++;
                                           errores = errores+nLinea+"|Error de sintaxis: Etiqueta + :\n"; 
                                        }
                                        if(espacios.hasMoreTokens()){
                                            nErrores++;
                                            errores = errores+nLinea+"|Error de sintaxis: Etiqueta + :\n";
                                        }else{
                                            boolean errorEtiqueta = true;
                                            for(int ciclo = 0; ciclo < sizeTemp; ciclo++){
                                                if(etiquetaComparacion.equals(etiquetasBn[ciclo][0])){
                                                    etiquetasBn[ciclo][1] = ""+nLinea;
                                                    etiquetasBn[ciclo][2] = "V";
                                                    errorEtiqueta = false;
                                                    break;
                                                }
                                            }
                                            if(errorEtiqueta){
                                                nErrores++;
                                                errores = errores+nLinea+"|Error de ambiguedad: No declaraste esa etiqueta en el stack\n";
                                            }
                                        }
                                    }else{
                                        nErrores++;
                                        errores = errores+nLinea+"|Error de sintaxis: Etiqueta + :\n";
                                    }
                                }else{
                                    String [][] var = variables.getVariables();
                                    int sizeVar = variables.getSizeArray();
                                    pReservadas.setSizeVariables(sizeVar);
                                    pReservadas.setVariables(var);
                                    pReservadas.automata(linea, nLinea);
                                    salto =  pReservadas.getSalto();
                                }
                            }else{
                                nErrores++;
                                errores = errores+nLinea+"|Falta JNZ dentro de LOOP\n";
                            }
                        }
                        
                        bnPReservadas = true;
                        break;
                    default:
                        
                }
                if(bnEtiqueta){
                    bnEtiqueta = false;
                    break;
                }
                if(bnVariable){
                    bnVariable=false;
                    break;
                }
                if(bnPReservadas){
                    bnPReservadas=false;
                    break;
                }
            }
            bnBreak = amta.getBnBreak();
            }
        }
        if(!bnBreak){
            ss = amta.getSs();
            ds = amta.getDs();
            cs = amta.getCs();
            if(!ss){
                nErrores++;
                errores = errores+ "Falta el segmento SS\n";
            }
            if(!ds){
                nErrores++;
                errores = errores+ "Falta el segmento DS\n";
            }
            if(!cs){
                nErrores++;
                errores = errores+ "Falta el segmento CS\n";
            }

            endCs= amta.getEndCs();
            if(!endCs){
                if(!(nErrores>0)){
                    nErrores++;
                    errores = errores+ nLinea+"Falta cerrar el segmento CS\n";
                }
            }
            nS = new int[3];
            nS = amta.getnS();
            if(!(nS[0]==1)){
                nErrores++;
                errores = errores+"El segmento SS debe ser el primero\n";
            }
            if(!(nS[1]==2)){
                nErrores++;
                errores = errores+"El segmento DS debe ser el segundo\n";
            }
            if(!(nS[2]==3)){
                nErrores++;
                errores = errores+"El segmento CS debe ser el tercero\n";
            }
            
            
            
            //variables.ambiguedad();7
            error = variables.getErrores();
                if(!(error.equals(""))){
                    nErrores++;
                    errores = errores+error;
                }

            error = etiqueta.getErrores();
                if(!(error.equals(""))){
                    nErrores++;
                    errores = errores+error;
                }
                
            error = pReservadas.getErrores();
                if(!(error.equals(""))){
                    nErrores++;
                    errores = errores+error;
                }
                
        }else{
            nErrores++;
        }
        if(salto){
            nErrores++;
            errores = errores+"\nFalta un JNZ antes del END CS";
        }
        
        for(int ciclo = 0; ciclo < sizeTemp; ciclo++){
            if(etiquetasBn[ciclo][2].equals("F")){
                nErrores++;
                errores = errores+"Error semantico: Hace falta segmento de codigo de la etiqueta: "+etiquetasBn[ciclo][0]+"\n";
            }
        }
        
        if(nErrores == 0){
            //System.out.println("Todo esta correcto :D!");
            jTextPane1.setText("");
            JOptionPane.showMessageDialog(this, "Todo es correcto :D!!!");
            
            /*for(int ciclo = 0; sizeTemp > ciclo; ciclo++){
                System.out.println(etiquetasBn[ciclo][0]);
                System.out.println(etiquetasBn[ciclo][1]);
                System.out.println(etiquetasBn[ciclo][2]);
            }*/
            mostrarEtiquetas();
            mostrarVar();
            //System.out.println(etiqueta.etiquetas[0]);
        }else{
            jTextPane1.setText(errores);
            fEtiquetas = 0;
            fVar = 0;
        }
        //jTextArea1.setText(nCodigo);
    }//GEN-LAST:event_jButton1ActionPerformed
    
    public void mostrarEtiquetas(){
        fEtiquetas = 0;
        for(int f = 0; f<sizeTemp; f++){
            model.insertRow(f, new Object[]{});
            fEtiquetas++;
            model.setValueAt(etiquetasBn[f][0],f,0);
            model.setValueAt(etiquetasBn[f][1],f,1);
        }
    }
    
    public void limpiarEtiquetas(){
        for(int f = 0; f<fEtiquetas; f++){    
                model.removeRow(0);
        }
        
    }
    
    public void mostrarVar(){
        fVar = 0;
        for(int f = 0; f<sizeVar; f++){
            model2.insertRow(f, new Object[]{});
            fVar++;
            model2.setValueAt(variablesBn[f][0],f,0);
            model2.setValueAt(variablesBn[f][1],f,1);
            if(variablesBn[f][2].equals("")){
                model2.setValueAt("NULL",f,2);
            }else{
                model2.setValueAt(variablesBn[f][2],f,2);
            }
        }
    }
    
    public void limpiarVar(){
        for(int f = 0; f<fVar; f++){    
                model2.removeRow(0);
        }
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextPane jTextPane1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    // End of variables declaration//GEN-END:variables
}
