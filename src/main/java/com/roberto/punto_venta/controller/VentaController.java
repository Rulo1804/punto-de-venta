package com.roberto.punto_venta.controller;

import com.roberto.punto_venta.model.DetalleVenta;
import com.roberto.punto_venta.model.ItemVenta;
import com.roberto.punto_venta.model.Producto;
import com.roberto.punto_venta.model.Venta;
import com.roberto.punto_venta.repository.DetalleVentaRepository;
import com.roberto.punto_venta.service.IClienteService;
import com.roberto.punto_venta.service.IProductoService;
import com.roberto.punto_venta.service.IVentaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class VentaController {

    private final IVentaService ventaService;
    private final IClienteService clienteService;
    private final IProductoService productoService;
    private final DetalleVentaRepository detalleVentaRepository;

    public VentaController(
            IVentaService ventaService,
            IClienteService clienteService,
            IProductoService productoService,
            DetalleVentaRepository detalleVentaRepository) {

        this.ventaService = ventaService;
        this.clienteService = clienteService;
        this.productoService = productoService;
        this.detalleVentaRepository = detalleVentaRepository;
    }


    // Listar las ventas

    @GetMapping("/ventas")
    public String listarVentas(Model model) {

        List<Venta> ventas =
                ventaService.listarVentas();

        model.addAttribute(
                "ventas",
                ventas
        );

        return "ventas/list";
    }


    //Nueva venta

    @GetMapping("/ventas/nueva")
    public String nuevaVenta(
            Model model,
            HttpSession session) {

        // Clientes

        model.addAttribute(
                "clientes",
                clienteService.listarClientes()
        );


        //Prodcutos

        model.addAttribute(
                "productos",
                productoService.listarProductos()
        );


        //Cliente seleccionadp

        Integer clienteId =
                (Integer) session.getAttribute("clienteId");

        model.addAttribute(
                "clienteId",
                clienteId
        );


        //Carrito

        List<ItemVenta> carrito =
                (List<ItemVenta>) session.getAttribute("carrito");

        if (carrito == null) {

            carrito = new ArrayList<>();
        }


        //SUBTOTAL

        BigDecimal subtotal =
                BigDecimal.ZERO;

        for (ItemVenta item : carrito) {

            subtotal = subtotal.add(
                    item.getSubtotal()
            );
        }


        //IVA
        BigDecimal iva =
                subtotal.multiply(
                        new BigDecimal("0.16")
                );


        //Total

        BigDecimal total =
                subtotal.add(iva);


        // Enviar a Thymeleaf

        model.addAttribute(
                "carrito",
                carrito
        );

        model.addAttribute(
                "subtotal",
                subtotal
        );

        model.addAttribute(
                "iva",
                iva
        );

        model.addAttribute(
                "total",
                total
        );


        return "ventas/form";
    }


    // Seleccionar cliente

    @PostMapping("/ventas/cliente")
    public String seleccionarCliente(
            @RequestParam Integer clienteId,
            HttpSession session) {

        session.setAttribute(
                "clienteId",
                clienteId
        );

        return "redirect:/ventas/nueva";
    }


    //Agregar producto

    @PostMapping("/ventas/agregar")
    public String agregarProducto(
            @RequestParam Integer idProducto,
            HttpSession session) {

        Producto producto =
                productoService.findById(idProducto);


        if (producto == null) {

            return "redirect:/ventas/nueva";
        }


        List<ItemVenta> carrito =
                (List<ItemVenta>) session.getAttribute("carrito");


        if (carrito == null) {

            carrito = new ArrayList<>();
        }


        boolean encontrado = false;


        //PRodcuto ya existe

        for (ItemVenta item : carrito) {

            if (item.getProducto()
                    .getIdProducto()
                    .equals(idProducto)) {

                // No superar stock

                if (item.getCantidad()
                        < producto.getStock()) {

                    item.setCantidad(
                            item.getCantidad() + 1
                    );
                }

                encontrado = true;

                break;
            }
        }


        //Producto Nuevo

        if (!encontrado &&
                producto.getStock() > 0) {

            carrito.add(
                    new ItemVenta(
                            producto,
                            1
                    )
            );
        }


        // Guardar carrito

        session.setAttribute(
                "carrito",
                carrito
        );


        return "redirect:/ventas/nueva";
    }

    //Aumentar la Cantidad

    @PostMapping("/ventas/aumentar")
    public String aumentarCantidad(
            @RequestParam Integer idProducto,
            HttpSession session) {

        List<ItemVenta> carrito =
                (List<ItemVenta>) session.getAttribute("carrito");

        if (carrito != null) {

            Producto producto =
                    productoService.findById(idProducto);

            for (ItemVenta item : carrito) {

                if (item.getProducto()
                        .getIdProducto()
                        .equals(idProducto)) {

                    if (item.getCantidad() < producto.getStock()) {

                        item.setCantidad(
                                item.getCantidad() + 1
                        );
                    }

                    break;
                }
            }

            session.setAttribute("carrito", carrito);
        }

        return "redirect:/ventas/nueva";
    }


    //Disminuir Cantidad

    @PostMapping("/ventas/disminuir")
    public String disminuirCantidad(
            @RequestParam Integer idProducto,
            HttpSession session) {

        List<ItemVenta> carrito =
                (List<ItemVenta>) session.getAttribute("carrito");

        if (carrito != null) {

            for (ItemVenta item : carrito) {

                if (item.getProducto()
                        .getIdProducto()
                        .equals(idProducto)) {

                    if (item.getCantidad() > 1) {

                        item.setCantidad(
                                item.getCantidad() - 1
                        );
                    }

                    break;
                }
            }

            session.setAttribute("carrito", carrito);
        }

        return "redirect:/ventas/nueva";
    }

    //Eliminar prodcuto

    @PostMapping("/ventas/eliminar")
    public String eliminarProducto(
            @RequestParam Integer idProducto,
            HttpSession session) {

        List<ItemVenta> carrito =
                (List<ItemVenta>) session.getAttribute("carrito");

        if (carrito != null) {

            carrito.removeIf(item ->
                    item.getProducto()
                            .getIdProducto()
                            .equals(idProducto)
            );

            session.setAttribute("carrito", carrito);
        }

        return "redirect:/ventas/nueva";
    }

    //Guardar la venta

    @PostMapping("/ventas/guardar")
    public String guardarVenta(
            HttpSession session) {


        //Cliente

        Integer clienteId =
                (Integer) session.getAttribute(
                        "clienteId"
                );


        if (clienteId == null) {

            return "redirect:/ventas/nueva";
        }


        //Carrito

        List<ItemVenta> carrito =
                (List<ItemVenta>) session.getAttribute(
                        "carrito"
                );


        if (carrito == null ||
                carrito.isEmpty()) {

            return "redirect:/ventas/nueva";
        }


        //Buscar cliente

        var cliente =
                clienteService.findById(
                        clienteId
                );


        //Verificar el stock

        for (ItemVenta item : carrito) {

            boolean hayStock =
                    productoService.hayStock(
                            item.getProducto()
                                    .getIdProducto(),

                            item.getCantidad()
                    );


            if (!hayStock) {

                return "redirect:/ventas/nueva";
            }
        }

        //Crear la venta

        Venta venta =
                new Venta();

        venta.setCliente(
                cliente
        );

        venta.setFecha(
                LocalDateTime.now()
        );


        //Sacar y calcuraqr el subtotaL

        BigDecimal subtotal =
                BigDecimal.ZERO;


        for (ItemVenta item : carrito) {

            subtotal = subtotal.add(
                    item.getSubtotal()
            );
        }


        //La parte del IVA

        BigDecimal iva =
                subtotal.multiply(
                        new BigDecimal("0.16")
                );


        //Total

        BigDecimal total =
                subtotal.add(iva);


        venta.setTotal(
                total
        );


        //Guardar la venta

        Venta ventaGuardada =
                ventaService.save(
                        venta
                );


        //Guardar detalles y reducir el stock

        for (ItemVenta item : carrito) {

            DetalleVenta detalle =
                    new DetalleVenta();


            detalle.setVenta(
                    ventaGuardada
            );


            detalle.setProducto(
                    item.getProducto()
            );


            detalle.setCantidad(
                    item.getCantidad()
            );


            detalle.setPrecioUnitario(
                    item.getProducto()
                            .getPrecioVenta()
            );


            // Guardar detalle

            detalleVentaRepository.save(
                    detalle
            );


            // Reducir stock

            productoService.reducirStock(
                    item.getProducto()
                            .getIdProducto(),

                    item.getCantidad()
            );
        }


        //Limpiar la venta

        session.removeAttribute(
                "carrito"
        );

        session.removeAttribute(
                "clienteId"
        );


        //Regresar a ventas

        return "redirect:/ventas";
    }
}