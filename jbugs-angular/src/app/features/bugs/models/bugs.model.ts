export interface BugJSON {

  title: string;
  description: string;
  version: string;
  targetDate: string;
  status: string;
  fixedVersion: string;
  severity: string;
  CREATED_ID: number;
  ASSIGNED_ID: number;
}


export class Bug {
  title: string;
  description: string;
  version: string;
  targetDate: any;
  status: string;
  fixedVersion: string;
  severity: string;
  CREATED_ID: number;
  ASSIGNED_ID: number;
  
  static fromJSON(json: BugJSON): Bug {
    const termin = new Bug();
    termin.title = json.title;
    termin.description = json.description;
    termin.version = json.version;
    termin.targetDate = json.targetDate;
    termin.status = json.status;
    termin.fixedVersion = json.fixedVersion;
    termin.severity = json.severity;
    termin.CREATED_ID = json.CREATED_ID;
    termin.ASSIGNED_ID = json.ASSIGNED_ID;
    return termin;
  }

  static toJSON(bug: Bug): BugJSON {
    return <BugJSON>{
      title: bug.title,
      description: bug.description,
      version: bug.version,
      targetDate: bug.targetDate,
      status: bug.status,
      fixedVersion: bug.fixedVersion,
      severity: bug.severity,
      CREATED_ID: bug.CREATED_ID,
      ASSIGNED_ID: bug.ASSIGNED_ID
    };
  }

  static createEmpty(): Bug {
    const bug = new Bug();
    return bug;
  }
}
