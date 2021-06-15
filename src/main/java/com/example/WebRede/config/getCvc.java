package com.example.WebRede.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class getCvc {
	
	
	public String destiny() {

		String path = System.getProperty("user.dir") + "\\src";
		File sourceFile = new File(path);
		String sourceFolderStr = sourceFile.getParent();
		return sourceFolderStr;
	}

	public List<ips> getAllIp() {
		List<ips> list = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(destiny() + "\\Database\\Database.csv"))) {
			br.readLine(); 
			String itemCsv = br.readLine();

			while (itemCsv != null) {
				String fields[] = itemCsv.split(",");
				
				String id_equip = fields[0];
				String name = fields[1];
				String ip = fields[2];
				String num_switch = fields[3];
				String porta = fields[4];
				String num_interface = fields[5];
				String num_link = fields[6];
				String untag = fields[7];
				String tag = fields[8];
				String login = fields[9];
				String senha = fields[10];
				String monitoravel = fields[11];
				String ipcomzero = fields[12];

				list.add(new ips(id_equip, name, ip, num_switch, porta, num_interface, num_link, untag, tag, login, senha, monitoravel, ipcomzero));
				itemCsv = br.readLine();
			}
			return list;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
