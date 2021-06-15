package com.example.WebRede.config;

public class ips {
		
		//id_equip,"nome","ip","num_switch","porta","num_interface","num_link","untag","tag","login","senha","monitoravel","ipcomzero"
		private String id_equip;
		private String name;
		private String ip;
		private String num_switch;
		private String porta;
		private String num_interface;
		private String num_link;
		private String untag;
		private String tag;
		private String login;
		private String senha;
		private String monitoravel;
		private String ipcomzero;
		
		public ips() {
		}

		public ips(String id_equip, String name, String ip, String num_switch, String porta, String num_interface,
				String num_link, String untag, String tag, String login, String senha, String monitoravel,
				String ipcomzero) {
			super();
			this.id_equip = id_equip;
			this.name = name;
			this.ip = ip;
			this.num_switch = num_switch;
			this.porta = porta;
			this.num_interface = num_interface;
			this.num_link = num_link;
			this.untag = untag;
			this.tag = tag;
			this.login = login;
			this.senha = senha;
			this.monitoravel = monitoravel;
			this.ipcomzero = ipcomzero;
		}

		public String getId_equip() {
			return id_equip;
		}

		public void setId_equip(String id_equip) {
			this.id_equip = id_equip;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getIp() {
			return ip;
		}

		public void setIp(String ip) {
			this.ip = ip;
		}

		public String getNum_switch() {
			return num_switch;
		}

		public void setNum_switch(String num_switch) {
			this.num_switch = num_switch;
		}

		public String getPorta() {
			return porta;
		}

		public void setPorta(String porta) {
			this.porta = porta;
		}

		public String getNum_interface() {
			return num_interface;
		}

		public void setNum_interface(String num_interface) {
			this.num_interface = num_interface;
		}

		public String getNum_link() {
			return num_link;
		}

		public void setNum_link(String num_link) {
			this.num_link = num_link;
		}

		public String getUntag() {
			return untag;
		}

		public void setUntag(String untag) {
			this.untag = untag;
		}

		public String getTag() {
			return tag;
		}

		public void setTag(String tag) {
			this.tag = tag;
		}

		public String getLogin() {
			return login;
		}

		public void setLogin(String login) {
			this.login = login;
		}

		public String getSenha() {
			return senha;
		}

		public void setSenha(String senha) {
			this.senha = senha;
		}

		public String getMonitoravel() {
			return monitoravel;
		}

		public void setMonitoravel(String monitoravel) {
			this.monitoravel = monitoravel;
		}

		public String getIpcomzero() {
			return ipcomzero;
		}

		public void setIpcomzero(String ipcomzero) {
			this.ipcomzero = ipcomzero;
		}

		@Override
		public String toString() {
			return "ips [id_equip=" + id_equip + "]--[name=" + name + "]--[ip=" + ip + "]-- [num_switch=" + num_switch + "]-- [porta="
					+ porta + "]-- [num_interface=" + num_interface + "]-- [num_link=" + num_link + "]-- [untag=" + untag + "]-- [tag="
					+ tag + "]-- [login=" + login + "]-- [senha=" + senha + "]-- [monitoravel=" + monitoravel + "]-- [ipcomzero="
					+ ipcomzero + "]";
		}
}
