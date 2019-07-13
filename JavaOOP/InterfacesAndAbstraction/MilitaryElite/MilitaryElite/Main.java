package InterfacesAndAbstraction.MilitaryElite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, Private> privates = new HashMap<>();

        List<Soldier> soldiers = new ArrayList<>();

        String command = "";

        while (!"End".equals(command=reader.readLine())) {
            String[] splitCommand = command.split("\\s+");
            String commandName = splitCommand[0];

            switch (commandName) {
                case "Private":
                    int privateId = Integer.parseInt(splitCommand[1]);
                    String privateFirstName = splitCommand[2];
                    String privateLastName = splitCommand[3];
                    double privateSalary = Double.parseDouble(splitCommand[4]);

                    Private priv = new PrivateImpl(privateId, privateFirstName, privateLastName, privateSalary);

                    soldiers.add(priv);
                    privates.put(priv.getId(), priv);
                    break;
                case "LeutenantGeneral":
                    int generalId = Integer.parseInt(splitCommand[1]);
                    String generalFirstName = splitCommand[2];
                    String generalLastName = splitCommand[3];
                    double generalSalary = Double.parseDouble(splitCommand[4]);

                    LieutenantGeneral general = new LieutenantGeneralImpl(generalId, generalFirstName, generalLastName, generalSalary);

                    for (int i = 5; i < splitCommand.length; i++) {
                        int toFindId = Integer.parseInt(splitCommand[i]);
                        general.addPrivate(privates.get(toFindId));
                    }

                    soldiers.add(general);
                    break;
                case "Engineer":
                    int engineerId = Integer.parseInt(splitCommand[1]);
                    String engineerFirstName = splitCommand[2];
                    String engineerLastName = splitCommand[3];
                    double engineerSalary = Double.parseDouble(splitCommand[4]);

                    if (splitCommand[5].equals("Marines") || splitCommand[5].equals("Airforces")) {
                        Corps corps = Corps.valueOf(splitCommand[5]);

                        Engineer engineer = new EngineerImpl(engineerId, engineerFirstName, engineerLastName, engineerSalary, corps);

                        for (int i = 6; i < splitCommand.length; i+=2) {
                            String repairName = splitCommand[i];
                            int hoursWorked = Integer.parseInt(splitCommand[i + 1]);

                            Repair repair = new RepairImpl(repairName, hoursWorked);

                            engineer.addRepair(repair);
                        }

                        soldiers.add(engineer);
                    }
                    break;
                case "Commando":
                    int commandoId = Integer.parseInt(splitCommand[1]);
                    String commandoFirstName = splitCommand[2];
                    String commandoLastName = splitCommand[3];
                    double commandoSalary = Double.parseDouble(splitCommand[4]);

                    if (splitCommand[5].equals("Marines") || splitCommand[5].equals("Airforces")) {
                        Corps corps = Corps.valueOf(splitCommand[5]);

                        Commando commando = new CommandoImpl(commandoId, commandoFirstName, commandoLastName, commandoSalary, corps);

                        for (int i = 6; i < splitCommand.length; i+=2) {
                            if (splitCommand[i + 1].equals("inProgress") || splitCommand[i + 1].equals("Finished")) {
                                String missionName = splitCommand[i];
                                State missionState = State.valueOf(splitCommand[i + 1]);

                                Mission mission = new MissionImpl(missionName, missionState);

                                commando.addMission(mission);
                            }
                        }

                        soldiers.add(commando);
                    }
                    break;
                case "Spy":
                    int spyId = Integer.parseInt(splitCommand[1]);
                    String spyFirstName = splitCommand[2];
                    String spyLastName = splitCommand[3];
                    String spyCodeNumber = splitCommand[4];

                    Spy spy = new SpyImpl(spyId, spyFirstName, spyLastName, spyCodeNumber);

                    soldiers.add(spy);
                    break;
            }
        }

        for (Soldier soldier : soldiers) {
            System.out.println(soldier.toString());
        }
    }
}