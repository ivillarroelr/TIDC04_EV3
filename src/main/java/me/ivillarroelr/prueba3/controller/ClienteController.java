package me.ivillarroelr.prueba3.controller;

import me.ivillarroelr.prueba3.dto.DepositoClienteDTO;
import me.ivillarroelr.prueba3.dto.DepositoDTO;
import me.ivillarroelr.prueba3.model.Cliente;
import me.ivillarroelr.prueba3.model.Cuenta;
import me.ivillarroelr.prueba3.model.Movimientos;
import me.ivillarroelr.prueba3.service.IClienteService;
import me.ivillarroelr.prueba3.service.ICuentaService;
import me.ivillarroelr.prueba3.service.IMovimientosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Set;

@Controller
public class ClienteController {

    @Autowired
    private IClienteService service;

    @Autowired
    private ICuentaService servicioCuenta;

    @Autowired
    private IMovimientosService servicioMovimientos;

    @GetMapping("/cliente")
    public ModelAndView index() {
        ModelAndView model = new ModelAndView();
        model.setViewName("cliente");
        return model;
    }

    @GetMapping("/depositarcliente.html")
    public ModelAndView depositarCliente() {
        ModelAndView model = new ModelAndView();
        model.setViewName("depositarcliente");
        return model;
    }

    @GetMapping("/consultar_saldo.html")
    public ModelAndView consultarSaldo(Principal principal){
        String rut = principal.getName();
        Cliente cliente = service.leerPorId(rut);
        Set<Cuenta> cuentas = servicioCuenta.cuentasUsuario(rut);
        ModelAndView model = new ModelAndView();
        model.setViewName("consultar_saldo");
        model.addObject("nombre", cliente.getUsuario().getNombre());
        model.addObject("apellido", cliente.getUsuario().getApellido());
        model.addObject("rut", rut);
        model.addObject("cuentas", cuentas);
        return model;
    }

    @PostMapping("/depositarcliente")
    public ModelAndView depositarCuenta(@ModelAttribute("cuenta") DepositoClienteDTO deposito) {

        Cuenta ctOrigen = servicioCuenta.leerPorId(deposito.getCuentaorigen());
        Cuenta ctDestino = servicioCuenta.leerPorId(deposito.getCuentadestino());
        ModelAndView model = new ModelAndView();
        Integer montoDeposito = 0;

        if (ctDestino.getNumerocta() == null) {
            model.setViewName("depositar");
            model.addObject("booleanerror", true);
            model.addObject("error", "Cuenta destino no existe");
            return model;
        }

        if (ctOrigen.getNumerocta() == null) {
            model.setViewName("depositar");
            model.addObject("booleanerror", true);
            model.addObject("error", "Cuenta origen no existe");
            return model;
        }

        if (ctOrigen.getSaldo() < Integer.parseInt(deposito.getMonto()) & ctOrigen.getSaldolineacredito() < Integer.parseInt(deposito.getMonto())) {
            model.setViewName("depositar");
            model.addObject("booleanerror", true);
            model.addObject("error", "Cuenta no posee fondos suficientes");
            return model;
        }else{
            if(ctOrigen.getSaldo() > Integer.parseInt(deposito.getMonto())){
                montoDeposito = Integer.parseInt(deposito.getMonto());
            }
            if(ctOrigen.getSaldolineacredito() > Integer.parseInt(deposito.getMonto())){
                montoDeposito = Integer.parseInt(deposito.getMonto());
            }
        }

        Integer saldoPrevio = ctDestino.getSaldo();
        Integer nuevoSaldo = saldoPrevio+montoDeposito;
        ctDestino.setSaldo(nuevoSaldo);
        servicioCuenta.modificar(ctDestino);
        Movimientos mv = new Movimientos();
        mv.setCuentaFK(ctDestino);
        mv.setDescripcion(montoDeposito+" depositados por la aplicacion web");
        LocalDateTime lt = LocalDateTime.now();
        mv.setFecha(lt);
        servicioMovimientos.registrar(mv);
        model.setViewName("depositarcliente");
        model.addObject("mostrar", true);
        model.addObject("numero_cuenta", ctDestino.getNumerocta());
        model.addObject("propietario", ctDestino.getClienteFK().getUsuario().getRut());
        model.addObject("saldo_previo", saldoPrevio);
        model.addObject("monto_deposito", montoDeposito);
        model.addObject("nuevo_saldo", nuevoSaldo);
        return model;
    }
}
