/**
 * @name Test.java 
 * 
 * @version 1.0 
 * 
 * @date 19 sept. 2017 
 * 
 * @author josef_000 
 * 
 * @copyright Nombre Empresa. All rights reserved.
 */
package corp.cencosud.ominicanales;

import java.io.File;
import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @description sssss
 *
 */
public class Test {
	
	private static final String RUTA_ENVIO = "C:/Share/Inbound/OMNICANAL";
	private final static double fB = 1024.0;
	
	/**
     * Devuelve una cadena de texto con el tamaño de archivo en su debida
     * nomenclatura Decimal del Sistema Internacional:sssss
     * "bytes, KB, MB, GB, TB, EB, PB, ZB, YB".
     * Donde bytes es la unidad mas pequeña equivalente a 8 bits.
     * @see <a href="http://es.wikipedia.org/wiki/Kilobyte">WikiES: KB = Kilobyte</a>
     * @see <a href="http://es.wikipedia.org/wiki/Megabyte">WikiES: MB = Megabyte</a>
     * @see <a href="http://es.wikipedia.org/wiki/Gigabyte">WikiES: GB = Gigabyte</a>
     * @see <a href="http://es.wikipedia.org/wiki/Terabyte">WikiES: TB = Terabyte</a>
     * @see <a href="http://es.wikipedia.org/wiki/Petabyte">WikiES: MB = Petabyte</a>
     * @see <a href="http://es.wikipedia.org/wiki/Exabyte">WikiES: EB = Exabyte</a>
     * @see <a href="http://es.wikipedia.org/wiki/Zettabyte">WikiES: ZB = Zettabyte</a>
     * @see <a href="http://es.wikipedia.org/wiki/Yottabyte">WikiES: YB = Zettabyte</a>
     * @param path Ruta de archivo que se desea verificar
     * @return tamaño en "bytes, KB, MB, GB, TB, EB, PB, ZB, YB"
     */
    public static String getFileSizeISDecimal (String path) {
        File file = new File(path);
        if (file.exists()) {
            double fL = file.length();
            if (fL <= fB) {
                return String.valueOf(fL).concat(" bytes");
            } else {
                double sizeKB = getFileSizeInKB(fL);
                if(getFileSizeInKB(fL) <= fB)
                    return String.valueOf(sizeKB).concat(" KB");
                else {
                    double sizeMB = getFileSizeInMB(fL);
                    if(sizeMB <= fB)
                        return String.valueOf(sizeMB).concat(" MB");
                    else {
                        double sizeGB = getFileSizeInGB(fL);
                        if(sizeGB <= fB)
                            return String.valueOf(sizeGB).concat(" GB");
                        else {
                            double sizeTB = getFileSizeInTB(fL);
                            if(sizeTB <= fB)
                                return String.valueOf(sizeTB).concat(" TB");
                            else {
                                double sizePB = getFileSizeInPB(fL);
                                if(sizePB <= 1024)
                                    return String.valueOf(sizePB).concat(" PB");
                                else {
                                    double sizeEB = getFileSizeInEB(fL);
                                    if (sizeEB <= 1024)
                                        return String.valueOf(sizePB).concat(" EB");
                                    else {
                                        double sizeZB = getFileSizeInZB(fL);
                                        if (sizeZB <= 1024) {
                                            return String.valueOf(sizeZB).concat(" ZB");
                                        } else
                                            return String.valueOf(getFileSizeInYB(fL)).concat(" YB");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else {
            throw new java.util.EmptyStackException();
        }
    }
    
    
 
    /**
     * Recibe el tamaño de archivo y lo devuelve en Kilobytes
     * @param f para usos públicos el parámetro debe provenir de un objeto
     * double java.io.File.length();
     * @return Tamaño de archivo en Kilobytes
     */
    private static double getFileSizeInKB (double f) {
        f = (f/fB);
        int fs = (int) Math.pow(10,2);
        return Math.rint(f*fs)/fs;
    }
 
    /**
     * Recibe el tamaño de archivo y lo devuelve en Megabytes
     * @param f para usos públicos el parámetro debe provenir de un objeto
     * double java.io.File.length();
     * @return Tamaño de archivo en Megabytes
     */
    private static double getFileSizeInMB (double f) {
        f = f / Math.pow(fB,2);
        int fs = (int) Math.pow(10,2);
        return Math.rint(f*fs)/fs;
    }
 
    /**
     * Recibe el tamaño de archivo y lo devuelve en Gigabytes
     * @param f para usos públicos el parámetro debe provenir de un objeto
     * double java.io.File.length();
     * @return Tamaño de archivo en Gigabytes
     */
    private static double getFileSizeInGB (double f) {
        f = f / Math.pow(fB,3);
        int fs = (int) Math.pow(10,2);
        return Math.rint(f*fs)/fs;
    }
 
    /**
     * Recibe el tamaño de archivo y lo devuelve en Terabytes
     * @param f para usos públicos el parámetro debe provenir de un objeto
     * double java.io.File.length();
     * @return Tamaño de archivo en Kilobytes
     */
    private static double getFileSizeInTB (double f) {
        f = f / Math.pow(fB,4);
        int fs = (int) Math.pow(10,2);
        return Math.rint(f*fs)/fs;
    }
 
    /**
     * Recibe el tamaño de archivo y lo devuelve en Petabytes
     * @param f para usos públicos el parámetro debe provenir de un objeto
     * double java.io.File.length();
     * @return Tamaño de archivo en Petabytes
     */
    private static double getFileSizeInPB (double f) {
        f = f / Math.pow(fB,5);
        int fs = (int) Math.pow(10,2);
        return Math.rint(f*fs)/fs;
    }
 
    /**
     * Recibe el tamaño de archivo y lo devuelve en Exabytes
     * @param f para usos públicos el parámetro debe provenir de un objeto
     * double java.io.File.length();
     * @return Tamaño de archivo en Exabytes
     */
    private static double getFileSizeInEB (double f) {
        f = f / Math.pow(fB,5);
        int fs = (int) Math.pow(10,2);
        return Math.rint(f*fs)/fs;
    }
 
    /**
     * Recibe el tamaño de archivo y lo devuelve en Zettabytes
     * @param f para usos públicos el parámetro debe provenir de un objeto
     * double java.io.File.length();
     * @return Tamaño de archivo en Zettabytes
     */
    private static double getFileSizeInZB (double f) {
        f = f / Math.pow(fB,5);
        int fs = (int) Math.pow(10,2);
        return Math.rint(f*fs)/fs;
    }
 
    /**
     * Recibe el tamaño de archivo y lo devuelve en Yottabytes
     * @param f para usos públicos el parámetro debe provenir de un objeto
     * double java.io.File.length();
     * @return Tamaño de archivo en Yottabytes
     */
    private static double getFileSizeInYB (double f) {
        f = f / Math.pow(fB,6);
        int fs = (int) Math.pow(10,2);
        return Math.rint(f*fs)/fs;
    }
    


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file1              	= null;
		File file2              	= null;

		file1                   = new File(RUTA_ENVIO + "/" + "chi_paris_0_omni_mov_20170313_11.ctr");
		file2                   = new File(RUTA_ENVIO + "/" + "chi_paris_0_omni_mov_20170313_11.dat");
		System.out.println(""+ file1.length());
		System.out.println(""+ file2.length());
		
		
        String fileSize = getFileSizeISDecimal(file1.getAbsolutePath());
        System.out.println("========="+fileSize);
		
		
		 DecimalFormat df = new DecimalFormat("#.00");
		 System.out.println(df.format(file1.length()));
		 
		float sss = file2.length();
		System.out.println("ss="+ sss);

		System.out.println(""+ file1.length()/1024.0);
		System.out.println(""+ file2.length()/1024.0);

		System.out.println(""+ Redondear(String.valueOf(Redondear( String.valueOf(file1.length()/1024.0), 2)), 0));
		System.out.println(""+ Redondear(String.valueOf(Redondear( String.valueOf(file2.length()/1024.0), 2)), 0));

		System.out.println(""+ Redondear(String.valueOf(Redondear( String.valueOf(file1.length()), 2)), 0));
		System.out.println(""+ df.format( Integer.parseInt(Redondear(String.valueOf(Redondear( String.valueOf(file2.length()), 2)), 0))));
		
		//System.out.println(""+ Redondear(Math.round(Math.ceil(file2.length()/1024.0)));
		
		
		
		
		

	}
	
	public static  String Redondear(String valor, int decimales) {
		// TODO Auto-generated method stub
		BigDecimal numero;
	    String resultado = "";
	    String signo = "";

	    if ( (valor != null) && (valor.compareTo("") != 0)) {
	      if (valor.indexOf(",") != -1) {
	        valor = valor.replace(',', '.');
	      }
	      if (valor.substring(0, 1).compareTo("-") == 0) {
	        signo = "-";
	        valor = valor.substring(1, valor.length());
	      }
	      numero = new BigDecimal(valor);
	      resultado = numero.setScale(decimales, BigDecimal.ROUND_HALF_UP).toString();
	      return (signo + resultado);
	    }
	    else {
	      return ("");
	    }
	}

}
