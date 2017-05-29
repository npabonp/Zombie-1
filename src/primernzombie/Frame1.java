/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primernzombie;

import javax.swing.JFrame;

/**
 *
 * @author NataliaPabon
 */
public class Frame1 extends JFrame {

    private static Nivel1 instance1 = null;

    public Frame1() {
        add(Nivel1.getInstance1());
    }
}
