
import java.text.DecimalFormat;
import java.util.Scanner;

public class Examen2 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    final DecimalFormat decimal = new DecimalFormat("0.00");
    int max_prod = 100;
    String[] names = new String[max_prod];
    int[] qtys = new int[max_prod];
    double[] prices = new double[max_prod];
    int[] discs = new int[max_prod];
    int option, num_prods = 0, IVA = 0;
    double dollar = 0;

    do {
      System.out.println("----- MENU -----");
      System.out.println("1) AGREGAR PRODUCTOS");
      System.out.println("2) MODIFICAR PRODUCTOS");
      System.out.println("3) DETALLE DEL PRODUCTO");
      System.out.println("4) CONFIGURACIONES");
      System.out.println("5) ESTADISTICA");
      System.out.println("0) SALIR");
      System.out.print("Seleccione una opción: ");
      option = sc.nextInt();
      sc.nextLine();

      switch (option) {
        case 1:
          System.out.print("Nombre del producto: ");
          String name = sc.nextLine();

          System.out.print("Cantidad: ");
          int qty = sc.nextInt();

          System.out.print("Precio: ");
          double price = sc.nextDouble();

          if (qty < 0 || price < 0) {
            System.out.println("Error: Ingrese valores positivos.");
            break;
          }

          System.out.print("Descuento (%): ");
          int disc = sc.nextInt();

          names[num_prods] = name;
          qtys[num_prods] = qty;
          prices[num_prods] = price;
          discs[num_prods] = disc;
          num_prods++;

          System.out.println("Producto agregado correctamente.");
          break;
        case 2:
          System.out.print("Ingrese el nombre del producto a modificar: ");
          String mod_name = sc.nextLine();

          for (int i = 0; i < num_prods; i++) {
            if (names[i].equalsIgnoreCase(mod_name)) {
              System.out.print("Nueva cantidad: ");
              int mod_qty = sc.nextInt();

              System.out.print("Nuevo precio: ");
              double mod_price = sc.nextDouble();

              System.out.print("Nuevo descuento (%): ");
              int mod_disc = sc.nextInt();

              qtys[i] = mod_qty;
              prices[i] = mod_price;
              discs[i] = mod_disc;

              System.out.println("Producto modificado correctamente.");
              break;
            }
          }
          break;
        case 3:
          System.out.print("Ingrese el nombre del producto: ");
          String name_detail = sc.nextLine();

          for (int i = 0; i < num_prods; i++) {
            if (names[i].equalsIgnoreCase(name_detail)) {
              System.out.println("----- Detalle del Producto -----");
              System.out.println("Nombre: " + names[i]);
              System.out.println("Cantidad: " + qtys[i]);
              System.out.println(
                "Precio: " +
                prices[i] +
                " en BS, en divisas: " +
                (decimal.format(prices[i] / dollar))
              );
              System.out.println("Descuento (%): " + discs[i]);
              break;
            }
          }
          break;
        case 4:
          System.out.print("Ingrese el precio de las divisas: ");
          dollar = sc.nextDouble();
          sc.nextLine();

          System.out.print("Ingrese el valor del IVA (%): ");
          IVA = sc.nextInt();
          sc.nextLine();

          System.out.println("Configuraciones actualizadas:");
          System.out.println("Precio de las divisas: " + dollar);
          System.out.println("IVA: " + IVA + "%");

          System.out.println("Desea cambiar los valores? (S/N): ");
          String change = sc.nextLine();

          if (change.equalsIgnoreCase("S")) {
            System.out.print("Ingrese el nuevo precio de las divisas: ");
            dollar = sc.nextDouble();
            sc.nextLine();

            System.out.print("Ingrese el nuevo valor del IVA (%): ");
            IVA = sc.nextInt();
            sc.nextLine(); //

            System.out.println("Nuevas configuraciones:");
            System.out.println("Precio de las divisas: " + dollar);
            System.out.println("IVA: " + IVA + "%");
          }

          break;
        case 5:
          System.out.println("----- Estadísticas -----");
          int total_prods = num_prods, disc_obj = 0;
          double net_total = 0.0, gross_total = 0;
          double min_price = Double.MAX_VALUE;
          double max_price = Double.MIN_VALUE;
          int min_qty = Integer.MAX_VALUE;
          int max_qty = Integer.MIN_VALUE;
          String max_price_obj = "";
          String min_price_obj = "";
          String max_qty_obj = "";
          String min_qty_obj = "";

          for (int i = 0; i < num_prods; i++) {
            double precio = prices[i];
            int cantidad = qtys[i];

            double IVA_price = precio * (1 + IVA);
            net_total += IVA_price * cantidad;
            gross_total += precio * cantidad;

            if (discs[i] > 0) {
              disc_obj++;
            }

            if (precio > max_price) {
              max_price = precio;
              max_price_obj = names[i];
            }

            if (precio < min_price) {
              min_price = precio;
              min_price_obj = names[i];
            }

            if (cantidad > max_qty) {
              max_qty = cantidad;
              max_qty_obj = names[i];
            }

            if (cantidad < min_qty) {
              min_qty = cantidad;
              min_qty_obj = names[i];
            }
          }

          System.out.println("----- Estadísticas -----");
          System.out.println("Total de productos: " + total_prods);
          System.out.println(
            "Monto total de precios más IVA: " + decimal.format(net_total)
          );
          System.out.println(
            "Monto total de precios sin IVA: " + decimal.format(gross_total)
          );
          System.out.println("Productos con descuento: " + disc_obj);
          System.out.println("Producto con mayor precio: " + max_price_obj);
          System.out.println("Producto con menor precio: " + min_price_obj);
          System.out.println("Producto con mayor cantidad: " + max_qty_obj);
          System.out.println("Producto con menor cantidad: " + min_qty_obj);
          break;
        case 0:
          System.out.println("Cerrando menú...");
          break;
        default:
          System.out.println("Opción inválida. Intente nuevamente.");
          break;
      }
    } while (option != 0);
  }
}

