package me.ivillarroelr.prueba3.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import me.ivillarroelr.prueba3.dto.ClienteDTO;
import me.ivillarroelr.prueba3.dto.CuentaDTO;
import me.ivillarroelr.prueba3.dto.DepositoDTO;
import me.ivillarroelr.prueba3.dto.EjecutivoDTO;

import me.ivillarroelr.prueba3.model.Cliente;
import me.ivillarroelr.prueba3.model.Cuenta;
import me.ivillarroelr.prueba3.model.Ejecutivo;
import me.ivillarroelr.prueba3.model.Movimientos;
import me.ivillarroelr.prueba3.service.IClienteService;
import me.ivillarroelr.prueba3.service.ICuentaService;
import me.ivillarroelr.prueba3.service.IEjecutivoService;
import me.ivillarroelr.prueba3.service.IMovimientosService;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {

    @Autowired
    private IEjecutivoService servicioEjecutivo;

    @Autowired
    private IClienteService servicioCliente;

    @Autowired
    private ICuentaService servicioCuenta;

    @Autowired
    private IMovimientosService servicioMovimientos;

    @GetMapping({ "/", "/login" })
    public ModelAndView index() {
        ModelAndView model = new ModelAndView();
        model.setViewName("index");
        return model;
    }

    @GetMapping("/buscar_cliente.html")
    public ModelAndView buscarCliente() {
        ModelAndView model = new ModelAndView();
        model.setViewName("buscar_cliente");
        return model;
    }

    @GetMapping("/crear_cuenta.html")
    public ModelAndView crearCuenta() {
        ModelAndView model = new ModelAndView();
        model.setViewName("crear_cuenta");
        return model;
    }

    @GetMapping("/depositar.html")
    public ModelAndView depositar() {
        ModelAndView model = new ModelAndView();
        model.setViewName("depositar");
        return model;
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("ejecutivo") EjecutivoDTO ejecutivo) {
        Ejecutivo ej = servicioEjecutivo.leerPorId(ejecutivo.getRut());
        ModelAndView model = new ModelAndView();
        if (ej.getRut() == null) {
            model.setViewName("index");
            model.addObject("error", "Login fallido, el usuario no existe");
            return model;
        }
        if (ej.getClave().equals(ejecutivo.getClave())) {
            model.setViewName("ejecutivo");
            return model;
        } else {
            model.setViewName("index");
            model.addObject("error", "Login fallido, credenciales invalidas");
            return model;
        }
    }

    @PostMapping("/buscar_cliente")
    public ModelAndView buscarCliente(@ModelAttribute("cliente") ClienteDTO cliente) {
        Cliente cl = servicioCliente.leerPorId(cliente.getRut());
        ModelAndView model = new ModelAndView();
        if (cl.getRut() == null) {
            model.setViewName("buscar_cliente");
            model.addObject("error", "Cliente no existe en los registros");
            return model;
        } else if (cl.getRut().equals(cliente.getRut())) {
            model.setViewName("buscar_cliente");
            model.addObject("boolean", true);
            model.addObject("rut", cl.getRut());
            model.addObject("apellido", cl.getApellido());
            model.addObject("nombre", cl.getNombre());
            List<Movimientos> mv = servicioMovimientos.listar();
            model.addObject("movimientos", mv);
            return model;
        } else {
            model.setViewName("buscar_cliente");
            model.addObject("error", "Cliente no existe en los registros");
            return model;
        }
    }

    @PostMapping("/crear_cuenta")
    public ModelAndView crearCuenta(@ModelAttribute("cuenta") CuentaDTO cuenta) {
        Cliente cl = servicioCliente.leerPorId(cuenta.getCliente());
        ModelAndView model = new ModelAndView();
        if (cl.getRut() == null) {
            model.setViewName("crear_cuenta");
            model.addObject("error", "Cliente no existe en los registros");
            return model;
        }
        Cuenta ct = new Cuenta();
        ct.setClienteFK(cl);
        ct.setNumerocta(Integer.parseInt(cuenta.getNumeroCuenta()));
        ct.setClavetransaccion(servicioCuenta.getMD5("123"));
        ct.setSaldo(0);
        ct.setSaldolineacredito(100000);
        ct.setSaldolineacreditousado(0);
        ct.setEstado(1);
        servicioCuenta.registrar(ct);
        model.setViewName("crear_cuenta");
        model.addObject("boolean", true);
        model.addObject("nombre", cl.getNombre());
        model.addObject("apellido", cl.getApellido());
        model.addObject("rut", cl.getRut());
        model.addObject("clave_transaccion", ct.getClavetransaccion());
        model.addObject("saldo", ct.getSaldo());
        model.addObject("saldo_linea_credito", ct.getSaldolineacredito());
        model.addObject("saldo_linea_credito_usado", ct.getSaldolineacreditousado());
        model.addObject("estado_cuenta", ct.getEstado());
        return model;
    }

    @PostMapping("/depositar")
    public ModelAndView depositarCuenta(@ModelAttribute("cuenta") DepositoDTO deposito) {

        Cuenta ct = servicioCuenta.leerPorId(deposito.getNumeroCuenta());
        ModelAndView model = new ModelAndView();

        if (ct.getNumerocta() == null) {
            model.setViewName("depositar");
            model.addObject("booleanerror", true);
            model.addObject("error", "Cuenta no existe");
            return model;
        }
        Integer saldoPrevio = ct.getSaldo();
        Integer montoDeposito = Integer.parseInt(deposito.getMonto());
        Integer nuevoSaldo = saldoPrevio+montoDeposito;
        ct.setSaldo(nuevoSaldo);
        servicioCuenta.registrar(ct);
        Movimientos mv = new Movimientos();
        mv.setCuentaFK(ct);
        mv.setDescripcion(montoDeposito+" depositados por la aplicacion web");
        LocalDateTime lt = LocalDateTime.now(); 
        mv.setFecha(lt);
        servicioMovimientos.registrar(mv);

        model.setViewName("depositar");
        model.addObject("mostrar", true);
        model.addObject("numero_cuenta", ct.getNumerocta());
        model.addObject("propietario", ct.getClienteFK().getRut());
        model.addObject("saldo_previo", saldoPrevio);
        model.addObject("monto_deposito", montoDeposito);
        model.addObject("nuevo_saldo", nuevoSaldo);
        return model;
    }
    
    
}